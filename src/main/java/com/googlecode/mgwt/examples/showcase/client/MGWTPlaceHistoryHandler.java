package com.googlecode.mgwt.examples.showcase.client;

import java.util.LinkedList;
import java.util.logging.Logger;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.LegacyHandlerWrapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler.DefaultHistorian;
import com.google.gwt.place.shared.PlaceHistoryHandler.Historian;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class MGWTPlaceHistoryHandler {

	private Logger log = Logger.getLogger(getClass().getName());

	public MGWTPlaceHistoryHandler(PlaceHistoryMapper mapper) {
		this(mapper, new DefaultHistorian());

	}

	public MGWTPlaceHistoryHandler(PlaceHistoryMapper mapper, Historian historian) {
		this.mapper = mapper;
		this.historian = historian;

	}

	private final Historian historian;

	private final PlaceHistoryMapper mapper;

	private PlaceController placeController;

	private Place defaultPlace = Place.NOWHERE;

	private LinkedList<String> historyStack = new LinkedList<String>();

	/**
	 * Handle the current history token. Typically called at application start,
	 * to ensure bookmark launches work.
	 */
	public void handleCurrentHistory() {

		String token = historian.getToken();

		System.out.println("handle current history: '" + token + "'");
		handleTokenChange(token);

	}

	protected void handleTokenChange(String token) {
		System.out.println("handle token change: '" + token + "'");
		historyStack.clear();

		String[] split = token.split("%73");

		for (int i = 0; i < split.length - 1; i++) {
			historyStack.add(split[i]);

		}

		StringBuffer buffer = new StringBuffer();
		for (String hToken : historyStack) {
			buffer.append(hToken);
			historian.newItem(buffer.toString(), false);
			System.out.println("historian item: '" + buffer.toString() + "'");
			buffer.append("%73");
		}

		handleHistoryToken(split[split.length - 1]);

	}

	/**
	 * Legacy method tied to the old location for {@link EventBus}.
	 * 
	 * @deprecated use {@link #register(PlaceController, EventBus, Place)}
	 */
	@Deprecated
	public com.google.gwt.event.shared.HandlerRegistration register(PlaceController placeController, com.google.gwt.event.shared.EventBus eventBus, Place defaultPlace) {
		return new LegacyHandlerWrapper(register(placeController, (EventBus) eventBus, defaultPlace));
	}

	/**
	 * Initialize this place history handler.
	 * 
	 * @return a registration object to de-register the handler
	 */
	public HandlerRegistration register(PlaceController placeController, EventBus eventBus, Place defaultPlace) {
		this.placeController = placeController;
		this.defaultPlace = defaultPlace;

		final HandlerRegistration placeReg = eventBus.addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {
			public void onPlaceChange(PlaceChangeEvent event) {
				onPlaceChangeEvent(event);
			}
		});

		final HandlerRegistration historyReg = historian.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				handleTokenChange(event.getValue());

			}
		});

		return new HandlerRegistration() {
			public void removeHandler() {
				MGWTPlaceHistoryHandler.this.defaultPlace = Place.NOWHERE;
				MGWTPlaceHistoryHandler.this.placeController = null;
				placeReg.removeHandler();
				historyReg.removeHandler();
			}
		};
	}

	protected void onPlaceChangeEvent(PlaceChangeEvent event) {

		Place newPlace = event.getNewPlace();
		System.out.println("place: " + newPlace);

		String tokenForPlace = tokenForPlace(newPlace);
		if ("".equals(tokenForPlace)) {
			return;
		}
		StringBuffer buffer = new StringBuffer();
		for (String token : historyStack) {
			buffer.append(token + "%73");
		}

		historyStack.add(tokenForPlace);
		buffer.append(tokenForPlace);

		System.out.println("place change: '" + buffer.toString() + "'");
		historian.newItem(buffer.toString(), false);
	}

	/**
	 * Visible for testing.
	 */
	Logger log() {
		return log;
	}

	private void handleHistoryToken(String token) {

		Place newPlace = null;

		if ("".equals(token)) {
			newPlace = defaultPlace;
		}

		if (newPlace == null) {
			newPlace = mapper.getPlace(token);
		}

		if (newPlace == null) {
			log().warning("Unrecognized history token: " + token);
			newPlace = defaultPlace;
		}

		placeController.goTo(newPlace);
	}

	private String tokenForPlace(Place newPlace) {
		String token = mapper.getToken(newPlace);
		if (token != null) {
			return token;
		}

		if (defaultPlace.equals(newPlace)) {
			return "";
		}

		token = mapper.getToken(newPlace);
		if (token != null) {
			return token;
		}

		log().warning("Place not mapped to a token: " + newPlace);
		return "";
	}

}

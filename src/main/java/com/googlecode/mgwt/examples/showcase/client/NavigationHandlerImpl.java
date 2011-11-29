package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.History;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.mgwt.ui.client.MGWT;

public class NavigationHandlerImpl implements NavigationHandler {

	private final PlaceHistoryMapper mapper;
	private MGWTPlaceHistoryHandler mgwtPlaceHistoryHandler;
	private PlaceHistoryHandler placeHistoryHandler;

	public NavigationHandlerImpl(PlaceHistoryMapper mapper) {
		this.mapper = mapper;

		if (MGWT.getOsDetection().isAndroidPhone()) {
			mgwtPlaceHistoryHandler = new MGWTPlaceHistoryHandler(mapper);
		} else {
			placeHistoryHandler = new PlaceHistoryHandler(mapper);
		}
	}

	@Override
	public void goBack(Activity activity) {
		if (MGWT.getOsDetection().isAndroidPhone()) {
			History.back();
		} else {
			//TODO
		}

	}

	public HandlerRegistration register(PlaceController placeController, EventBus eventBus, Place defaultPlace) {
		if (mgwtPlaceHistoryHandler != null) {
			return mgwtPlaceHistoryHandler.register(placeController, eventBus, defaultPlace);
		}

		return placeHistoryHandler.register(placeController, eventBus, defaultPlace);

	}

	public void handleCurrentHistory() {
		if (mgwtPlaceHistoryHandler != null)
			mgwtPlaceHistoryHandler.handleCurrentHistory();

		placeHistoryHandler.handleCurrentHistory();
	}

}

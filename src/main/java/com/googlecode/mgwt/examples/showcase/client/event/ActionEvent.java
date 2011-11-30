package com.googlecode.mgwt.examples.showcase.client.event;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class ActionEvent extends Event<ActionEvent.Handler> {

	public interface Handler {
		void onAction(ActionEvent event);
	}

	private static final Type<ActionEvent.Handler> TYPE = new Type<ActionEvent.Handler>();

	public static void fire(EventBus eventBus, String sourceName) {
		eventBus.fireEventFromSource(new ActionEvent(), sourceName);
	}

	public static HandlerRegistration register(EventBus eventBus, String sourceName, Handler handler) {
		return eventBus.addHandlerToSource(TYPE, sourceName, handler);
	}

	@Override
	public com.google.web.bindery.event.shared.Event.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	protected ActionEvent() {

	}

	@Override
	protected void dispatch(ActionEvent.Handler handler) {
		handler.onAction(this);
	}

}

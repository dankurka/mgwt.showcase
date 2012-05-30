package com.googlecode.mgwt.examples.showcase.client.activities;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class UIEntrySelectedEvent extends Event<UIEntrySelectedEvent.Handler> {

	public enum UIEntry {
		BUTTON_BAR, BUTTONS, ELEMENTS, POPUPS, PROGRESS_BAR, PROGRESS_INDICATOR, PULL_TO_REFRESH, SCROLL_WIDGET, SEARCH_BOX, SLIDER, TABBAR, FORMS, CAROUSEL, CAROUSEL_VERT, GROUP_LIST
	}

	public interface Handler {
		void onAnimationSelected(UIEntrySelectedEvent event);
	}

	private static final Type<UIEntrySelectedEvent.Handler> TYPE = new Type<UIEntrySelectedEvent.Handler>();
	private final UIEntry entry;

	public static void fire(EventBus eventBus, UIEntry entry) {
		eventBus.fireEvent(new UIEntrySelectedEvent(entry));
	}

	public static HandlerRegistration register(EventBus eventBus, Handler handler) {
		return eventBus.addHandler(TYPE, handler);
	}

	@Override
	public com.google.web.bindery.event.shared.Event.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	protected UIEntrySelectedEvent(UIEntry entry) {
		this.entry = entry;

	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onAnimationSelected(this);

	}

	public static Type<UIEntrySelectedEvent.Handler> getType() {
		return TYPE;
	}

	public UIEntry getEntry() {
		return entry;
	}
}

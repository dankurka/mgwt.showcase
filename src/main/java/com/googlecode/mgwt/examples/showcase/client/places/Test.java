package com.googlecode.mgwt.examples.showcase.client.places;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.googlecode.mgwt.dom.client.event.touch.TouchCancelEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchEndEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchHandler;
import com.googlecode.mgwt.dom.client.event.touch.TouchMoveEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchMoveHandler;
import com.googlecode.mgwt.dom.client.event.touch.TouchStartEvent;
import com.googlecode.mgwt.ui.client.util.ImageLoader;
import com.googlecode.mgwt.ui.client.util.IsImage;
import com.googlecode.mgwt.ui.client.widget.touch.TouchWidget;

public class Test {
  public void bla() {

    Context2d ctx = Canvas.createIfSupported().getContext2d();

    ctx.fillRect(0, 0, 150, 150); // Draw a rectangle with default settings
    ctx.save(); // Save the default state

    ctx.setFillStyle("#09F"); // Make changes to the settings
    ctx.fillRect(15, 15, 120, 120); // Draw a rectangle with new settings

    ctx.save(); // Save the current state
    ctx.setFillStyle("#FFF"); // Make changes to the settings
    ctx.setGlobalAlpha(0.5);
    ctx.fillRect(30, 30, 90, 90); // Draw a rectangle with new settings

    ctx.restore(); // Restore previous state
    ctx.fillRect(45, 45, 60, 60); // Draw a rectangle with restored settings

    ctx.restore(); // Restore original state
    ctx.fillRect(60, 60, 30, 30); // Draw a rectangle with restored settings
  }
}

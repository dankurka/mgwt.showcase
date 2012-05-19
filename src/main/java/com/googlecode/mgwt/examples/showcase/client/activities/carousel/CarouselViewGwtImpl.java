/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.examples.showcase.client.activities.carousel;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

/**
 * @author Daniel Kurka
 * 
 */
public class CarouselViewGwtImpl extends DetailViewGwtImpl implements CarouselView {

	private Carousel carousel;

	public CarouselViewGwtImpl() {

		scrollPanel.removeFromParent();

		carousel = new Carousel();

		main.add(carousel);

		for (int i = 0; i < 5; i++) {

			ScrollPanel scrollPanel2 = new ScrollPanel();
			scrollPanel2.setScrollingEnabledX(false);
			// scrollPanel2.setWidth("100%");

			RoundPanel flowPanel3 = new RoundPanel();
			for (int j = 0; j < 10; j++) {
				HTML html = new HTML("Slide: " + (i + 1));
				html.getElement().getStyle().setMarginBottom(300, Unit.PX);
				flowPanel3.add(html);
			}

			scrollPanel2.setWidget(flowPanel3);

			carousel.add(scrollPanel2);
		}

	}

	@Override
	public HasSelectionHandlers<Integer> getSwipePanel() {
		return carousel;
	}

}

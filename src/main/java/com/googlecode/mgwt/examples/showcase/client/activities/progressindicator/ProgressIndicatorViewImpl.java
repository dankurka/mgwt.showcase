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
package com.googlecode.mgwt.examples.showcase.client.activities.progressindicator;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.examples.showcase.client.ChromeWorkaround;
import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.ui.client.widget.ProgressIndicator;

/**
 * @author Daniel Kurka
 * 
 */
public class ProgressIndicatorViewImpl extends DetailViewGwtImpl implements ProgressIndicatorView {

	public ProgressIndicatorViewImpl() {

		FlowPanel content = new FlowPanel();
		content.getElement().getStyle().setMarginTop(20, Unit.PX);

		ProgressIndicator progressIndicator = new ProgressIndicator();
		progressIndicator.getElement().setAttribute("style", "margin:auto; margin-top: 50px");

		content.add(progressIndicator);

		HTML html = new HTML("animation is purely done with css");
		html.getElement().setAttribute("style", "text-align: center; margin-top: 20px;");
		content.add(html);

		scrollPanel.setWidget(content);

		ChromeWorkaround.maybeUpdateScroller(scrollPanel);

	}

}

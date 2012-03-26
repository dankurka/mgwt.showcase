/*
 * Copyright 2012 Daniel Kurka
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
package com.googlecode.mgwt.examples.showcase.client.activities.forms;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.FormListEntry;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class FormsViewGwtImpl extends DetailViewGwtImpl implements FormsView {
	public FormsViewGwtImpl() {

		FlowPanel container = new FlowPanel();

		HTML header = new HTML("Contact Data");
		header.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());

		container.add(header);

		WidgetList widgetList = new WidgetList();
		widgetList.setRound(true);

		// lets put in some widgets
		widgetList.add(new FormListEntry("Firstname", new MTextBox()));
		widgetList.add(new FormListEntry("Lastname", new MTextBox()));
		widgetList.add(new FormListEntry("Job Title", new MTextBox()));

		container.add(widgetList);

		scrollPanel.setScrollingEnabledX(false);
		scrollPanel.setWidget(container);
		// workaround for android formfields jumping around when using
		// -webkit-transform
		scrollPanel.setUsePos(MGWT.getOsDetection().isAndroid());

	}
}

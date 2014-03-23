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
package com.googlecode.mgwt.examples.showcase.client.activities;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.examples.showcase.client.BasicCell;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.header.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.layout.RootLayoutPanel;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.list.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

import java.util.List;

/**
 * @author Daniel Kurka
 * 
 */
public class ShowCaseListViewGwtImpl implements ShowCaseListView {

	private RootLayoutPanel main;
	private HeaderButton forwardButton;
	private HeaderPanel headerPanel;
	private CellList<Topic> cellList;
  private HTML header;

	public ShowCaseListViewGwtImpl() {
		main = new RootLayoutPanel();

		headerPanel = new HeaderPanel();

		forwardButton = new HeaderButton();
		forwardButton.setForwardButton(true);
		if (MGWT.getOsDetection().isPhone()) {
			headerPanel.setRightWidget(forwardButton);
		}
		main.add(headerPanel);

		cellList = new CellList<Topic>(new BasicCell<Topic>() {

			@Override
			public String getDisplayString(Topic model) {
				return model.getName();
			}

			@Override
			public boolean canBeSelected(Topic model) {
				return true;
			}
		});

		cellList.setRound(true);
		
    FlowPanel container = new FlowPanel();
    
    header = new HTML("Contact Data");
    // TODO remove styling borrowed from celllist
//    header.addStyleName(CellList.DEFAULT_APPEARANCE.css().listHeader());

    container.add(header);
    container.add(cellList);


		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setWidget(container);
		scrollPanel.setScrollingEnabledX(false);
		main.add(scrollPanel);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void setTitle(String text) {
		headerPanel.setCenter(text);

	}

	@Override
	public void setRightButtonText(String text) {
		forwardButton.setText(text);
	}

	@Override
	public HasTapHandlers getAboutButton() {
		return forwardButton;
	}

	@Override
	public HasCellSelectedHandler getCellSelectedHandler() {
		return cellList;
	}

	@Override
	public void setTopics(List<Topic> createTopicsList) {
		cellList.render(createTopicsList);

	}

	@Override
	public HasText getFirstHeader() {
		return header;
	}
}

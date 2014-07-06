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
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.examples.showcase.client.BasicCell;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.button.image.AboutImageButton;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.header.HeaderTitle;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.list.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FixedSpacer;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexSpacer;
import com.googlecode.mgwt.ui.client.widget.panel.flex.RootFlexPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

import java.util.List;

/**
 * @author Daniel Kurka
 *
 */
public class ShowCaseListViewGwtImpl implements ShowCaseListView {

	private RootFlexPanel main;
	private AboutImageButton aboutButton;
	private HeaderPanel headerPanel;
	private CellList<Topic> cellList;
  private HeaderTitle headerPanelTitle = new HeaderTitle();

	public ShowCaseListViewGwtImpl() {
		main = new RootFlexPanel();

		headerPanel = new HeaderPanel();

		headerPanel.add(new FixedSpacer());
		headerPanel.add(new FlexSpacer());
		headerPanel.add(headerPanelTitle);
		headerPanel.add(new FlexSpacer());

		aboutButton = new AboutImageButton();
    if (MGWT.getFormFactor().isPhone()) {
      headerPanel.add(aboutButton);
    } else {
      headerPanel.add(new FixedSpacer());
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


    FlowPanel container = new FlowPanel();
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
		headerPanelTitle.setText(text);
	}

	@Override
	public HasTapHandlers getAboutButton() {
		return aboutButton;
	}

	@Override
	public HasCellSelectedHandler getCellSelectedHandler() {
		return cellList;
	}

	@Override
	public void setTopics(List<Topic> createTopicsList) {
		cellList.render(createTopicsList);
	}
}

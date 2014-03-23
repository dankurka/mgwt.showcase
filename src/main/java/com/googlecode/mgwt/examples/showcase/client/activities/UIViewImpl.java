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

import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.examples.showcase.client.BasicCell;
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
public class UIViewImpl implements UIView {

	private RootLayoutPanel main;
	private HeaderPanel headerPanel;
	private HeaderButton headerBackButton;
	private CellList<Item> cellListWithHeader;

	public UIViewImpl() {
		main = new RootLayoutPanel();

		main.getElement().setId("testdiv");

		headerPanel = new HeaderPanel();
		main.add(headerPanel);

		headerBackButton = new HeaderButton();
		headerBackButton.setBackButton(true);
		headerPanel.setLeftWidget(headerBackButton);
		headerBackButton.setVisible(!MGWT.getOsDetection().isAndroid());

		ScrollPanel scrollPanel = new ScrollPanel();

		cellListWithHeader = new CellList<Item>(new BasicCell<Item>() {

			@Override
			public String getDisplayString(Item model) {
				return model.getDisplayString();
			}

			@Override
			public boolean canBeSelected(Item model) {
				return true;
			}
		});
		cellListWithHeader.setRound(true);
		scrollPanel.setWidget(cellListWithHeader);
		scrollPanel.setScrollingEnabledX(false);

		main.add(scrollPanel);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void setBackButtonText(String text) {
		headerBackButton.setText(text);

	}

	@Override
	public HasTapHandlers getBackButton() {
		return headerBackButton;
	}

	@Override
	public void setTitle(String title) {
		headerPanel.setCenter(title);

	}

	@Override
	public HasCellSelectedHandler getList() {
		return cellListWithHeader;
	}

	@Override
	public void renderItems(List<Item> items) {
		cellListWithHeader.render(items);

	}

	@Override
	public void setSelectedIndex(int index, boolean selected) {
		cellListWithHeader.setSelectedIndex(index, selected);

	}

}

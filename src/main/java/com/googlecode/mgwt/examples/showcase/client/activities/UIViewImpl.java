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
import com.googlecode.mgwt.ui.client.widget.button.image.PreviousitemImageButton;
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
public class UIViewImpl implements UIView {

	private RootFlexPanel main;
	private HeaderPanel headerPanel;
	private PreviousitemImageButton headerBackButton;
	private CellList<Item> cellListWithHeader;
	private HeaderTitle headerTitle = new HeaderTitle();

	public UIViewImpl() {
		main = new RootFlexPanel();

		headerPanel = new HeaderPanel();
		main.add(headerPanel);

		headerBackButton = new PreviousitemImageButton();

		headerBackButton.setVisible(!MGWT.getOsDetection().isAndroid());

		headerPanel.add(headerBackButton);
		headerPanel.add(new FlexSpacer());
		headerPanel.add(headerTitle);
		headerPanel.add(new FlexSpacer());
		FixedSpacer fixedSpacer = new FixedSpacer();
    fixedSpacer.setVisible(!MGWT.getOsDetection().isAndroid());
    headerPanel.add(fixedSpacer);

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
		scrollPanel.setWidget(cellListWithHeader);
		scrollPanel.setScrollingEnabledX(false);

		main.add(scrollPanel);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasTapHandlers getBackButton() {
		return headerBackButton;
	}

	@Override
	public void setTitle(String title) {
	  headerTitle.setText(title);
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

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
package com.googlecode.mgwt.examples.showcase.client.activities.animation;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.examples.showcase.client.BasicCell;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.header.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.header.HeaderTitle;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.list.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexSpacer;
import com.googlecode.mgwt.ui.client.widget.panel.flex.RootFlexPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

import java.util.List;

/**
 * @author Daniel Kurka
 *
 */
public class AnimationViewGwtImpl implements AnimationView {

	private CellList<Animation> list;
	private RootFlexPanel main;
	private HeaderPanel headerPanel;
	private HeaderButton headerBackButton;
  private HTML header;
  private HeaderTitle headerTitle = new HeaderTitle();

	/**
	 *
	 */
	public AnimationViewGwtImpl() {
		main = new RootFlexPanel();

		headerPanel = new HeaderPanel();

		headerBackButton = new HeaderButton();

  	headerPanel.add(headerBackButton);
		headerBackButton.setBackButton(true);
		headerBackButton.setVisible(!MGWT.getOsDetection().isAndroid());

		headerPanel.add(new FlexSpacer());
		headerPanel.add(headerTitle);
		headerPanel.add(new FlexSpacer());

		main.add(headerPanel);

		ScrollPanel scrollPanel = new ScrollPanel();

		list = new CellList<Animation>(new BasicCell<Animation>() {

			@Override
			public String getDisplayString(Animation model) {
				return model.getName();
			}

			@Override
			public boolean canBeSelected(Animation model) {
				return true;
			}
		});

		list.setRound(true);

		FlowPanel container = new FlowPanel();

		header = new HTML("Contact Data");
    // TODO remove styling borrowed from celllist
//    header.addStyleName(CellList.DEFAULT_APPEARANCE.css().listHeader());

    container.add(header);
    container.add(list);

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
		headerTitle.setText(text);
	}

	@Override
	public HasTapHandlers getBackButton() {
		return headerBackButton;
	}

	@Override
	public HasCellSelectedHandler getCellSelectedHandler() {
		return list;
	}

	@Override
	public void setLeftButtonText(String text) {
		headerBackButton.setText(text);
	}

	@Override
	public void setAnimations(List<Animation> animations) {
		list.render(animations);
	}

	@Override
	public HasText getFirstHeader() {
		return header;
	}
}

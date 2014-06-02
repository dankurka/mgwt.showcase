package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.button.image.PreviousitemImageButton;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.header.HeaderTitle;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FixedSpacer;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexSpacer;
import com.googlecode.mgwt.ui.client.widget.panel.flex.RootFlexPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public abstract class DetailViewGwtImpl implements DetailView {

	protected RootFlexPanel main;
	protected ScrollPanel scrollPanel;
	protected HeaderPanel headerPanel;
	protected PreviousitemImageButton headerBackButton;
	protected HeaderTitle title;

	public DetailViewGwtImpl() {
		main = new RootFlexPanel();

		scrollPanel = new ScrollPanel();

		headerPanel = new HeaderPanel();



		headerBackButton = new PreviousitemImageButton();
		if(!MGWT.getOsDetection().isAndroid() && MGWT.getFormFactor().isPhone()) {
		  headerPanel.add(headerBackButton);
		}


		headerPanel.add(new FlexSpacer());
		title = new HeaderTitle();
    headerPanel.add(title);
    headerPanel.add(new FlexSpacer());

    if(!MGWT.getOsDetection().isAndroid() && MGWT.getFormFactor().isPhone()) {
      headerPanel.add(new FixedSpacer());
    }

		main.add(headerPanel);
		main.add(scrollPanel);
	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasText getHeader() {
		return title;
	}

	@Override
	public HasTapHandlers getBackbutton() {
		return headerBackButton;
	}
}

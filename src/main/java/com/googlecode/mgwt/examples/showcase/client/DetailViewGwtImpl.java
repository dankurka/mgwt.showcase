package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.header.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.header.HeaderTitle;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexSpacer;
import com.googlecode.mgwt.ui.client.widget.panel.flex.RootFlexPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public abstract class DetailViewGwtImpl implements DetailView {

	protected RootFlexPanel main;
	protected ScrollPanel scrollPanel;
	protected HeaderPanel headerPanel;
	protected HeaderButton headerBackButton;
	protected HeaderButton headerMainButton;
	protected HeaderTitle title;

	public DetailViewGwtImpl() {
		main = new RootFlexPanel();

		scrollPanel = new ScrollPanel();

		headerPanel = new HeaderPanel();



		headerBackButton = new HeaderButton();
		headerBackButton.setBackButton(true);
		headerBackButton.setVisible(!MGWT.getOsDetection().isAndroid());

		headerMainButton = new HeaderButton();
		headerMainButton.setRoundButton(true);

		if (!MGWT.getFormFactor().isPhone()) {
		  headerPanel.add(headerMainButton);
			// TODO
//			headerMainButton.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getUtilCss().portraitonly());
		} else {
		  headerPanel.add(headerBackButton);
		}

		headerPanel.add(new FlexSpacer());
		title = new HeaderTitle();
    headerPanel.add(title);
    headerPanel.add(new FlexSpacer());

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
	public HasText getBackbuttonText() {
		return headerBackButton;
	}

	@Override
	public HasTapHandlers getBackbutton() {
		return headerBackButton;
	}

	@Override
	public HasText getMainButtonText() {
		return headerMainButton;
	}

	@Override
	public HasTapHandlers getMainButton() {
		return headerMainButton;
	}
}

package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.header.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.layout.RootLayoutPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public abstract class DetailViewGwtImpl implements DetailView {

	protected RootLayoutPanel main;
	protected ScrollPanel scrollPanel;
	protected HeaderPanel headerPanel;
	protected HeaderButton headerBackButton;
	protected HeaderButton headerMainButton;
	protected HTML title;

	public DetailViewGwtImpl() {
		main = new RootLayoutPanel();

		scrollPanel = new ScrollPanel();

		headerPanel = new HeaderPanel();
		title = new HTML();
		headerPanel.setCenterWidget(title);
		headerBackButton = new HeaderButton();
		headerBackButton.setBackButton(true);
		headerBackButton.setVisible(!MGWT.getOsDetection().isAndroid());

		headerMainButton = new HeaderButton();
		headerMainButton.setRoundButton(true);

		if (!MGWT.getOsDetection().isPhone()) {
			headerPanel.setLeftWidget(headerMainButton);
			// TODO
//			headerMainButton.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getUtilCss().portraitonly());
		} else {
			headerPanel.setLeftWidget(headerBackButton);
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

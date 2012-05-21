package com.googlecode.mgwt.examples.showcase.client.activities.pulltorefresh;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.examples.showcase.client.ClientFactory;
import com.googlecode.mgwt.examples.showcase.client.DetailActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowStandardHandler;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowStandardHandler.PullActionHandler;

public class PullToRefreshActivity extends DetailActivity {

	private final ClientFactory clientFactory;

	private int counter;
	private List<Topic> list = new LinkedList<Topic>();

	public PullToRefreshActivity(ClientFactory clientFactory) {
		super(clientFactory.getPullToRefreshDisplay(), "nav");
		this.clientFactory = clientFactory;

		list = new LinkedList<Topic>();
		while (counter < 20) {
			list.add(new Topic("Topic " + (counter + 1), counter));
			counter++;
		}

	}

	private boolean failedHeader = false;

	private boolean failedFooter = false;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);

		final PullToRefreshDisplay display = clientFactory.getPullToRefreshDisplay();

		display.getHeader().setText("Pulldown to Refresh");

		display.getMainButtonText().setText("Nav");
		display.getBackbuttonText().setText("UI");
		display.getHeader().setText("PullToRefresh");

		display.getPullHeader().setHTML("pull down");

		display.getPullFooter().setHTML("pull up");

		PullArrowStandardHandler headerHandler = new PullArrowStandardHandler(display.getPullHeader(), display.getPullPanel());

		headerHandler.setErrorText("Error");
		headerHandler.setLoadingText("Loading");
		headerHandler.setNormalText("pull down");
		headerHandler.setPulledText("release to load");
		headerHandler.setPullActionHandler(new PullActionHandler() {

			@Override
			public void onPullAction(final AsyncCallback<Void> callback) {
				new Timer() {

					@Override
					public void run() {

						if (failedHeader) {
							callback.onFailure(null);

						} else {
							for (int i = 0; i < 5; i++) {
								list.add(0, new Topic("generated Topic " + (counter + 1), counter));
								counter++;
							}
							display.render(list);
							display.refresh();

							callback.onSuccess(null);

						}
						failedHeader = !failedHeader;

					}
				}.schedule(1000);

			}
		});

		display.setHeaderPullHandler(headerHandler);

		PullArrowStandardHandler footerHandler = new PullArrowStandardHandler(display.getPullFooter(), display.getPullPanel());

		footerHandler.setErrorText("Error");
		footerHandler.setLoadingText("Loading");
		footerHandler.setNormalText("pull up");
		footerHandler.setPulledText("release to load");
		footerHandler.setPullActionHandler(new PullActionHandler() {

			@Override
			public void onPullAction(final AsyncCallback<Void> callback) {
				new Timer() {

					@Override
					public void run() {

						if (failedFooter) {
							callback.onFailure(null);

						} else {
							for (int i = 0; i < 5; i++) {
								list.add(list.size(), new Topic("generated Topic " + (counter + 1), counter));
								counter++;
							}
							display.render(list);
							display.refresh();

							callback.onSuccess(null);

						}
						failedFooter = !failedFooter;

					}
				}.schedule(1000);

			}
		});

		display.setFooterPullHandler(footerHandler);

		display.render(list);

		panel.setWidget(display);
	}
}

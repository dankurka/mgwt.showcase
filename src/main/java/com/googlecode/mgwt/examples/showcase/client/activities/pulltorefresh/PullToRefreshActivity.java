package com.googlecode.mgwt.examples.showcase.client.activities.pulltorefresh;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.examples.showcase.client.ClientFactory;
import com.googlecode.mgwt.examples.showcase.client.DetailActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel.PullWidget;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel.PullWidget.PullState;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel.Pullhandler;

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

	private boolean failed = false;
	private boolean callRunning = false;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);

		final PullToRefreshDisplay display = clientFactory.getPullToRefreshDisplay();

		display.getHeader().setText("Pulldown to Refresh");

		display.getMainButtonText().setText("Nav");
		display.getBackbuttonText().setText("UI");
		display.getHeader().setText("PullToRefresh");

		display.setPullHandler(new Pullhandler() {

			@Override
			public void onPullStateChanged(PullWidget pullWidget, PullState state) {
				switch (state) {
				case NORMAL:
					pullWidget.setHTML("pull down");
					break;
				case PULLED:
					pullWidget.setHTML("release to load");
					break;

				default:
					break;
				}

			}

			@Override
			public void onPullAction(final PullWidget pullWidget) {
				if (callRunning)
					return;
				callRunning = true;
				pullWidget.setHTML("loading");

				display.getPullArrowWidget().showLoadingIndicator();

				new Timer() {

					@Override
					public void run() {
						callRunning = false;
						if (failed) {
							display.getPullArrowWidget().showError();
							pullWidget.setHTML("Error");
							callRunning = true;

							new Timer() {

								@Override
								public void run() {
									callRunning = false;
									display.refresh();

									pullWidget.setHTML("pull down");
									display.getPullArrowWidget().showArrow();

								}
							}.schedule(1000);

						} else {
							for (int i = 0; i < 5; i++) {
								list.add(0, new Topic("generated Topic " + (counter + 1), counter));
								counter++;
							}
							display.render(list);
							display.refresh();

							pullWidget.setHTML("pull down");
							display.getPullArrowWidget().showArrow();

						}
						failed = !failed;

					}
				}.schedule(1000);

			}
		});

		display.render(list);

		panel.setWidget(display);
	}
}

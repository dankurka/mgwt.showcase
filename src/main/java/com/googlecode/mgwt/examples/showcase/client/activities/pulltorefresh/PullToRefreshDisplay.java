package com.googlecode.mgwt.examples.showcase.client.activities.pulltorefresh;

import java.util.List;

import com.googlecode.mgwt.examples.showcase.client.DetailView;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowWidget;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel.Pullhandler;

public interface PullToRefreshDisplay extends DetailView {

	public void render(List<Topic> topics);

	public void setPullHandler(Pullhandler pullHandler);

	public PullArrowWidget getPullArrowWidget();

	public void refresh();

}

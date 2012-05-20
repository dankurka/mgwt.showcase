package com.googlecode.mgwt.examples.showcase.client.activities.pulltorefresh;

import java.util.List;

import com.googlecode.mgwt.examples.showcase.client.DetailView;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.widget.base.HasRefresh;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowWidget;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel.Pullhandler;

public interface PullToRefreshDisplay extends DetailView {

	public void render(List<Topic> topics);

	public void setHeaderPullHandler(Pullhandler pullHandler);

	public void setFooterPullHandler(Pullhandler pullHandler);

	public PullArrowWidget getPullHeader();

	public PullArrowWidget getPullFooter();

	public void refresh();

	public HasRefresh getPullPanel();

}

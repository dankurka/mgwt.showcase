package com.googlecode.mgwt.examples.showcase.client.activities.pulltorefresh;

import java.util.List;

import com.googlecode.mgwt.examples.showcase.client.BasicCell;
import com.googlecode.mgwt.examples.showcase.client.ChromeWorkaround;
import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.base.HasRefresh;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowFooter;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowHeader;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowWidget;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel.Pullhandler;

public class PullToRefreshDisplayGwtImpl extends DetailViewGwtImpl implements PullToRefreshDisplay {

	private PullPanel pullToRefresh;
	private CellList<Topic> cellList;

	private PullArrowHeader pullArrowHeader;
	private PullArrowFooter pullArrowFooter;

	public PullToRefreshDisplayGwtImpl() {
		main.remove(scrollPanel);

		pullToRefresh = new PullPanel();

		pullArrowHeader = new PullArrowHeader();

		pullToRefresh.setHeader(pullArrowHeader);

		pullArrowFooter = new PullArrowFooter();
		pullToRefresh.setFooter(pullArrowFooter);

		main.add(pullToRefresh);

		cellList = new CellList<Topic>(new BasicCell<Topic>() {

			@Override
			public String getDisplayString(Topic model) {
				return model.getName();
			}
		});

		pullToRefresh.add(cellList);

		ChromeWorkaround.maybeUpdateScroller(scrollPanel);
	}

	@Override
	public void render(List<Topic> topics) {
		cellList.render(topics);

	}

	@Override
	public void setHeaderPullHandler(Pullhandler pullHandler) {
		pullToRefresh.setHeaderPullhandler(pullHandler);

	}

	@Override
	public PullArrowWidget getPullHeader() {
		return pullArrowHeader;
	}

	@Override
	public void refresh() {
		pullToRefresh.refresh();

	}

	@Override
	public void setFooterPullHandler(Pullhandler pullHandler) {
		pullToRefresh.setFooterPullHandler(pullHandler);

	}

	@Override
	public PullArrowWidget getPullFooter() {
		return pullArrowFooter;
	}

	@Override
	public HasRefresh getPullPanel() {
		return pullToRefresh;
	}

}

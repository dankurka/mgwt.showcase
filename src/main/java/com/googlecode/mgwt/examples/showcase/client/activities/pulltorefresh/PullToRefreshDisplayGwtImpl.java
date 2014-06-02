package com.googlecode.mgwt.examples.showcase.client.activities.pulltorefresh;

import com.googlecode.mgwt.examples.showcase.client.BasicCell;
import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.widget.base.HasRefresh;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.panel.pull.PullArrowFooter;
import com.googlecode.mgwt.ui.client.widget.panel.pull.PullArrowHeader;
import com.googlecode.mgwt.ui.client.widget.panel.pull.PullArrowWidget;
import com.googlecode.mgwt.ui.client.widget.panel.pull.PullPanel;
import com.googlecode.mgwt.ui.client.widget.panel.pull.PullPanel.Pullhandler;

import java.util.List;

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

	}

	@Override
	public void render(List<Topic> topics) {
		cellList.render(topics);

	}

	@Override
	public void setHeaderPullHandler(Pullhandler pullHandler) {
		pullToRefresh.setHeaderPullHandler(pullHandler);

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

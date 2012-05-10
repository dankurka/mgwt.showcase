package com.googlecode.mgwt.examples.showcase.client.activities.pulltorefresh;

import java.util.List;

import com.googlecode.mgwt.examples.showcase.client.BasicCell;
import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowHeader;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowWidget;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel.Pullhandler;

public class PullToRefreshDisplayGwtImpl extends DetailViewGwtImpl implements PullToRefreshDisplay {

	private PullPanel pullToRefresh;
	private CellList<Topic> cellList;

	private PullArrowHeader pullArrowHeader;

	public PullToRefreshDisplayGwtImpl() {
		main.remove(scrollPanel);

		pullToRefresh = new PullPanel();

		pullArrowHeader = new PullArrowHeader();

		pullToRefresh.setHeader(pullArrowHeader);

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
	public void setPullHandler(Pullhandler pullHandler) {
		pullToRefresh.setHeaderPullhandler(pullHandler);

	}

	@Override
	public PullArrowWidget getPullArrowWidget() {
		return pullArrowHeader;
	}

	@Override
	public void refresh() {
		pullToRefresh.refresh();

	}

}

/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.examples.showcase.client.activities.gcell;

import java.util.List;

import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.ui.client.widget.GroupingCellList;
import com.googlecode.mgwt.ui.client.widget.HeaderList;
import com.googlecode.mgwt.ui.client.widget.GroupingCellList.CellGroup;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

/**
 * @author Daniel Kurka
 * 
 */
public class GroupedCellListGwtImpl extends DetailViewGwtImpl implements GroupedCellListView {

	private HeaderList<Header, Content> headerList;

	/**
	 * 
	 */
	public GroupedCellListGwtImpl() {
		scrollPanel.removeFromParent();

		GroupingCellList<Header, Content> groupingCellList = new GroupingCellList<Header, Content>(new ContentCell(), new HeaderCell());
		headerList = new HeaderList<Header, Content>(groupingCellList);

		main.add(headerList);

	}

	private static class ContentCell implements Cell<Content> {

		@Override
		public void render(SafeHtmlBuilder safeHtmlBuilder, Content model) {
			safeHtmlBuilder.appendEscaped(model.getName());

		}

		@Override
		public boolean canBeSelected(Content model) {
			return true;
		}

	}

	private static class HeaderCell implements Cell<Header> {

		@Override
		public void render(SafeHtmlBuilder safeHtmlBuilder, Header model) {
			safeHtmlBuilder.appendEscaped(model.getName());
		}

		@Override
		public boolean canBeSelected(Header model) {
			return false;
		}

	}

	@Override
	public void render(List<CellGroup<Header, Content>> models) {
		headerList.render(models);

	}

}

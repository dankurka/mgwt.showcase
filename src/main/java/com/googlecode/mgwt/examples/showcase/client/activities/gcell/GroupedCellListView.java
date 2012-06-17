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

import com.googlecode.mgwt.examples.showcase.client.DetailView;
import com.googlecode.mgwt.ui.client.widget.GroupingCellList.CellGroup;

/**
 * @author Daniel Kurka
 * 
 */
public interface GroupedCellListView extends DetailView {

	public void render(List<CellGroup<Header, Content>> models);

	public class Header {
		private final String name;

		public Header(String name) {
			this.name = name;

		}

		public String getName() {
			return name;
		}

	}

	public class Content {

		private final String name;

		public Content(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

}

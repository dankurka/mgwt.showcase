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
package com.googlecode.mgwt.examples.showcase.client.activities;

import com.googlecode.mgwt.examples.showcase.client.activities.UIEntrySelectedEvent.UIEntry;

/**
 * @author Daniel Kurka
 * 
 */
public class Item {
	private String displayString;
	private final UIEntry entry;

	public Item(String displayString, UIEntry entry) {
		this.displayString = displayString;
		this.entry = entry;

	}

	/**
	 * @return the displayString
	 */
	public String getDisplayString() {
		return displayString;
	}

	public UIEntry getEntry() {
		return entry;
	}
}

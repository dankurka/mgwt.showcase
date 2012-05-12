/*
 * Copyright 2012 Daniel Kurka
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
package com.googlecode.mgwt.examples.showcase.client;

import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

public class ChromeWorkaround {

	private static boolean isChrome = isChrome();

	// workaround for chrome bug
	// see: http://code.google.com/p/mgwt/issues/detail?id=164
	public static void maybeUpdateScroller(ScrollPanel scrollPanel) {
		// no impact on production
		// this compiles out!
		if (!MGWT.getOsDetection().isDesktop())
			return;
		if (isChrome) {
			scrollPanel.setUsePos(true);
		}
	}

	private static native boolean isChrome()/*-{
		return navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
	}-*/;

}

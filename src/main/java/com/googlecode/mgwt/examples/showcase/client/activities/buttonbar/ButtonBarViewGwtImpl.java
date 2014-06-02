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
package com.googlecode.mgwt.examples.showcase.client.activities.buttonbar;

import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.ui.client.widget.button.image.CameraImageButton;
import com.googlecode.mgwt.ui.client.widget.button.image.NewImageButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarText;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexSpacer;

/**
 * @author Daniel Kurka
 */
public class ButtonBarViewGwtImpl extends DetailViewGwtImpl implements ButtonBarView {

	private ButtonBar footerPanel;

	public ButtonBarViewGwtImpl() {
		footerPanel = new ButtonBar();
		footerPanel.add(new NewImageButton());
		footerPanel.add(new FlexSpacer());
		footerPanel.add(new ButtonBarText("there are about 140 buttons"));
		footerPanel.add(new FlexSpacer());
		footerPanel.add(new CameraImageButton());
		main.add(footerPanel);
	}
}

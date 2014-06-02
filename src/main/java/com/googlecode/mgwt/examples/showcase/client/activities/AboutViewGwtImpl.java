/*
 * Copyright 2010 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.examples.showcase.client.activities;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HTML;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.examples.showcase.client.DetailViewGwtImpl;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.button.Button;
import com.googlecode.mgwt.ui.client.widget.panel.Panel;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexPanel;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexPropertyHelper.Alignment;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexPropertyHelper.Orientation;

/**
 * @author Daniel Kurka
 *
 */
public class AboutViewGwtImpl extends DetailViewGwtImpl implements AboutView {

  private Panel round;
  private Button button;

  public AboutViewGwtImpl() {



    round = new Panel();

    FlexPanel flexPanel = new FlexPanel();
    flexPanel.setOrientation(Orientation.VERTICAL);
    flexPanel.setAlignment(Alignment.CENTER);
    round.add(flexPanel);
    round.setRound(true);

    flexPanel.add(new HTML("mgwt"));
    flexPanel.add(new HTML("Version 2.0.0-SNAPSHOT"));
    flexPanel.add(new HTML("Built by Daniel Kurka, <a target='_blank' href='http://www.twitter.com/dankurka'>@dankurka</a> on Twitter"));

    flexPanel.add(new HTML("Using GWT to build mobile apps"));

    flexPanel.add(new HTML("<br/><br/><a target='_blank' href='http://www.m-gwt.com'>www.m-gwt.com</a><br/><br/>"));

    if (MGWT.getFormFactor().isPhone()) {
      button = new Button("back");

      flexPanel.add(button);
    }

    scrollPanel.setWidget(round);
    scrollPanel.setScrollingEnabledX(false);

  }

  @Override
  public HasTapHandlers getBackbutton() {

    final HasTapHandlers superB = super.getBackbutton();

    return new HasTapHandlers() {

      @Override
      public HandlerRegistration addTapHandler(TapHandler handler) {
        HandlerRegistration hr = null;
        if (MGWT.getOsDetection().isPhone()) {
          hr= button.addTapHandler(handler);
        }
        final HandlerRegistration hr1 = hr;
        final HandlerRegistration hr2 = superB.addTapHandler(handler);
        return new HandlerRegistration() {

          @Override
          public void removeHandler() {
            if(hr1 != null){
              hr1.removeHandler();
            }
            hr2.removeHandler();
          }
        };
      }
    };

  }

}

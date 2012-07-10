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
package com.googlecode.mgwt.examples.showcase.client.activities.animation;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.examples.showcase.client.ClientFactory;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.Animation.AnimationNames;
import com.googlecode.mgwt.examples.showcase.client.event.ActionEvent;
import com.googlecode.mgwt.examples.showcase.client.event.ActionNames;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

/**
 * @author Daniel Kurka
 * 
 */
public class AnimationActivity extends MGWTAbstractActivity {

  private final ClientFactory clientFactory;
  private List<Animation> animations;

  /**
	 * 
	 */
  public AnimationActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;

  }

  @Override
  public void start(AcceptsOneWidget panel, final EventBus eventBus) {
    AnimationView view = clientFactory.getAnimationView();

    view.setLeftButtonText("Home");
    view.setTitle("Animation");
    animations = createAnimations();
    view.setAnimations(animations);

    addHandlerRegistration(view.getBackButton().addTapHandler(new TapHandler() {

      @Override
      public void onTap(TapEvent event) {
        ActionEvent.fire(eventBus, ActionNames.BACK);

      }
    }));

    addHandlerRegistration(view.getCellSelectedHandler().addCellSelectedHandler(
        new CellSelectedHandler() {

          @Override
          public void onCellSelected(CellSelectedEvent event) {
            int index = event.getIndex();

            AnimationSelectedEvent.fire(eventBus, animations.get(index));

          }
        }));

    panel.setWidget(view);

  }

  /**
   * @return
   */
  private List<Animation> createAnimations() {
    ArrayList<Animation> list = new ArrayList<Animation>();

    list.add(new Animation(AnimationNames.SLIDE, "Slide"));
    list.add(new Animation(AnimationNames.SLIDE_UP, "Slide up"));
    list.add(new Animation(AnimationNames.DISSOLVE, "Dissolve"));
    list.add(new Animation(AnimationNames.FADE, "Fade"));
    list.add(new Animation(AnimationNames.FLIP, "Flip"));
    list.add(new Animation(AnimationNames.POP, "Pop"));
    list.add(new Animation(AnimationNames.SWAP, "Swap"));
    // list.add(new Animation("Cube"));

    return list;
  }

}

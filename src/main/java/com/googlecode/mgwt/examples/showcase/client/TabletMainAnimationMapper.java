package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.AnimationPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationDissolvePlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationFadePlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationFlipPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationPopPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSlidePlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSlideUpPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSwapPlace;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.widget.animation.Animation;
import com.googlecode.mgwt.ui.client.widget.animation.Animations;

public class TabletMainAnimationMapper implements AnimationMapper {

  @Override
  public Animation getAnimation(Place oldPlace, Place newPlace) {
    if (oldPlace == null) {
      return Animations.FADE;
    }

    // animation

    if (oldPlace instanceof AnimationSlidePlace && newPlace instanceof AnimationPlace) {
      return Animations.SLIDE_REVERSE;
    }

    if (newPlace instanceof AnimationSlideUpPlace) {
      return Animations.SLIDE_UP;
    }

    if (oldPlace instanceof AnimationSlideUpPlace && newPlace instanceof AnimationPlace) {
      return Animations.SLIDE_UP_REVERSE;
    }

    if (newPlace instanceof AnimationDissolvePlace) {
      return Animations.DISSOLVE;
    }

    if (oldPlace instanceof AnimationDissolvePlace && newPlace instanceof AnimationPlace) {
      return Animations.DISSOLVE_REVERSE;
    }

    if (newPlace instanceof AnimationFadePlace) {
      return Animations.FADE;
    }

    if (oldPlace instanceof AnimationFadePlace && newPlace instanceof AnimationPlace) {
      return Animations.FADE_REVERSE;
    }
    if (newPlace instanceof AnimationFlipPlace) {
      return Animations.FLIP;
    }

    if (oldPlace instanceof AnimationFlipPlace && newPlace instanceof AnimationPlace) {
      return Animations.FLIP_REVERSE;
    }

    if (newPlace instanceof AnimationPopPlace) {
      return Animations.POP;
    }

    if (oldPlace instanceof AnimationPopPlace && newPlace instanceof AnimationPlace) {
      return Animations.POP_REVERSE;
    }

    if (newPlace instanceof AnimationSwapPlace) {
      return Animations.SWAP;
    }

    if (oldPlace instanceof AnimationSwapPlace && newPlace instanceof AnimationPlace) {
      return Animations.SWAP_REVERSE;
    }

    // if (oldPlace instanceof AnimationCubePlace && newPlace instanceof AnimationPlace) {
    // return Animations.CUBE_REVERSE;
    // }
    //
    // if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationCubePlace) {
    // System.out.println("asdfasdf");
    // return Animations.CUBE;
    // }

    return Animations.SLIDE;
  }

}

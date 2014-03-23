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
package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.examples.showcase.client.activities.AboutPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.UIPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.AnimationPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationDissolvePlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationFadePlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationFlipPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationPopPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSlidePlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSlideUpPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSwapPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.button.ButtonPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.buttonbar.ButtonBarPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.carousel.CarouselPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.elements.ElementsPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.forms.FormsPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.gcell.GroupedCellListPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.popup.PopupPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.progressbar.ProgressBarPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.progressindicator.ProgressIndicatorPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.pulltorefresh.PullToRefreshPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.scrollwidget.ScrollWidgetPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.searchbox.SearchBoxPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.slider.SliderPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.tabbar.TabBarPlace;
import com.googlecode.mgwt.examples.showcase.client.places.HomePlace;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.widget.animation.Animation;
import com.googlecode.mgwt.ui.client.widget.animation.Animations;

/**
 * @author Daniel Kurka
 * 
 */
public class PhoneAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {

		if (oldPlace instanceof UIPlace && newPlace instanceof HomePlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof AboutPlace && newPlace instanceof HomePlace) {
			return Animations.SLIDE_UP_REVERSE;
		}

		if (oldPlace instanceof HomePlace && newPlace instanceof AboutPlace) {
			return Animations.SLIDE_UP;
		}

		if (oldPlace instanceof HomePlace && newPlace instanceof AnimationPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof HomePlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof HomePlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof ScrollWidgetPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ScrollWidgetPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof ElementsPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ElementsPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof FormsPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof FormsPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof ButtonBarPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ButtonBarPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof SearchBoxPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof SearchBoxPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof TabBarPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof TabBarPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof ButtonPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ButtonPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof PopupPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof PopupPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof ProgressBarPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ProgressBarPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof ProgressIndicatorPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ProgressIndicatorPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof SliderPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof SliderPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof PullToRefreshPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof PullToRefreshPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof CarouselPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof CarouselPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof GroupedCellListPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof GroupedCellListPlace && newPlace instanceof UIPlace) {
			return Animations.SLIDE_REVERSE;
		}

		// animation

		if (oldPlace instanceof AnimationSlidePlace && newPlace instanceof AnimationPlace) {
			return Animations.SLIDE_REVERSE;
		}

		// if (oldPlace instanceof AnimationCubePlace && newPlace instanceof
		// AnimationPlace) {
		// return Animation.CUBE_REVERSE;
		// }
		//
		// if (oldPlace instanceof AnimationPlace && newPlace instanceof
		// AnimationCubePlace) {
		// return Animation.CUBE;
		// }

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationSlideUpPlace) {
			return Animations.SLIDE_UP;
		}

		if (oldPlace instanceof AnimationSlideUpPlace && newPlace instanceof AnimationPlace) {
			return Animations.SLIDE_UP_REVERSE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationDissolvePlace) {
			return Animations.DISSOLVE;
		}

		if (oldPlace instanceof AnimationDissolvePlace && newPlace instanceof AnimationPlace) {
			return Animations.DISSOLVE_REVERSE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationFadePlace) {
			return Animations.FADE;
		}

		if (oldPlace instanceof AnimationFadePlace && newPlace instanceof AnimationPlace) {
			return Animations.FADE_REVERSE;
		}
		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationFlipPlace) {
			return Animations.FLIP;
		}

		if (oldPlace instanceof AnimationFlipPlace && newPlace instanceof AnimationPlace) {
			return Animations.FLIP_REVERSE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationPopPlace) {
			return Animations.POP;
		}

		if (oldPlace instanceof AnimationPopPlace && newPlace instanceof AnimationPlace) {
			return Animations.POP_REVERSE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationSwapPlace) {
			return Animations.SWAP;
		}

		if (oldPlace instanceof AnimationSwapPlace && newPlace instanceof AnimationPlace) {
			return Animations.SWAP_REVERSE;
		}

		return Animations.SLIDE;

	}
}

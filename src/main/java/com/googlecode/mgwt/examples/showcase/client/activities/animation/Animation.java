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
package com.googlecode.mgwt.examples.showcase.client.activities.animation;

/**
 * @author Daniel Kurka
 * 
 */
public class Animation {
	private String name;
	private AnimationNames animationName;

	public enum AnimationNames {
		SLIDE, SLIDE_UP, DISSOLVE, FADE, FLIP, POP, SWAP;

	}

	@SuppressWarnings("unused")
	private Animation() {

	}

	public Animation(AnimationNames animationName, String displayName) {
		this.animationName = animationName;
		this.name = displayName;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnimationNames getAnimationName() {
		return animationName;
	}

}

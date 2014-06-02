/*
 * x * Copyright 2010 Daniel Kurka
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
package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.RootPanel;

import com.googlecode.mgwt.examples.showcase.client.css.AppBundle;
import com.googlecode.mgwt.examples.showcase.client.places.HomePlace;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.mvp.client.history.MGWTPlaceHistoryHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.util.SuperDevModeUtil;
import com.googlecode.mgwt.ui.client.widget.animation.AnimationWidget;
import com.googlecode.mgwt.ui.client.widget.menu.overlay.OverlayMenu;

/**
 * @author Daniel Kurka
 *
 */
public class ShowCaseEntryPoint implements EntryPoint {

  private void start() {

    SuperDevModeUtil.showDevMode();

    ViewPort viewPort = new MGWTSettings.ViewPort();
    viewPort.setUserScaleAble(false).setMinimumScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);

    MGWTSettings settings = new MGWTSettings();
    settings.setViewPort(viewPort);
    settings.setIconUrl("logo.png");
    settings.setFullscreen(true);
    settings.setFixIOS71BodyBug(true);
    settings.setPreventScrolling(true);

    MGWT.applySettings(settings);

    final ClientFactory clientFactory = new ClientFactoryImpl();

    // Start PlaceHistoryHandler with our PlaceHistoryMapper
    AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

    if (MGWT.getFormFactor().isTablet() || MGWT.getFormFactor().isDesktop()) {
      // very nasty workaround because GWT does not corretly support
      // @media
      StyleInjector.inject(AppBundle.INSTANCE.css().getText());

      createTabletDisplay(clientFactory);
    } else {
      createPhoneDisplay(clientFactory);
    }

    AppHistoryObserver historyObserver = new AppHistoryObserver();

    MGWTPlaceHistoryHandler historyHandler = new MGWTPlaceHistoryHandler(historyMapper, historyObserver);

    historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new HomePlace());
    historyHandler.handleCurrentHistory();

  }

  private void createPhoneDisplay(ClientFactory clientFactory) {
    AnimationWidget display = new AnimationWidget();

    PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(clientFactory);

    PhoneAnimationMapper appAnimationMapper = new PhoneAnimationMapper();

    AnimatingActivityManager activityManager = new AnimatingActivityManager(appActivityMapper, appAnimationMapper, clientFactory.getEventBus());

    activityManager.setDisplay(display);

    RootPanel.get().add(display);

  }

  private void createTabletDisplay(ClientFactory clientFactory) {


    OverlayMenu overlayMenu = new OverlayMenu();

    AnimationWidget navDisplay = new AnimationWidget();


    ActivityMapper navActivityMapper = new TabletNavActivityMapper(clientFactory);

    AnimationMapper navAnimationMapper = new TabletNavAnimationMapper();

    AnimatingActivityManager navActivityManager = new AnimatingActivityManager(navActivityMapper, navAnimationMapper, clientFactory.getEventBus());

    navActivityManager.setDisplay(navDisplay);
    overlayMenu.setMaster(navDisplay);

    AnimationWidget mainDisplay = new AnimationWidget();

    TabletMainActivityMapper tabletMainActivityMapper = new TabletMainActivityMapper(clientFactory);

    AnimationMapper tabletMainAnimationMapper = new TabletMainAnimationMapper();

    AnimatingActivityManager mainActivityManager = new AnimatingActivityManager(tabletMainActivityMapper, tabletMainAnimationMapper, clientFactory.getEventBus());

    mainActivityManager.setDisplay(mainDisplay);
    overlayMenu.setDetail(mainDisplay);

    RootPanel.get().add(overlayMenu);

  }

  @Override
  public void onModuleLoad() {
    start();
  }

}

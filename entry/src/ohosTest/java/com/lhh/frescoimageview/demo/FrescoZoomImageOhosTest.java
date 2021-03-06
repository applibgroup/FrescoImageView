/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lhh.frescoimageview.demo;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.request.Postprocessor;
import lib.lhh.fiv.library.FrescoZoomImageView;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.components.Attr;
import ohos.agp.components.AttrSet;
import ohos.app.Context;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class FrescoZoomImageOhosTest {
    private final AttrSet attrSet = new AttrSet() {
        @Override
        public Optional<Attr> getAttr(int i) {
            return Optional.empty();
        }

        @Override
        public Optional<Attr> getAttr(String s) {
            return Optional.empty();
        }

        @Override
        public Optional<String> getStyle() {
            return Optional.empty();
        }

        @Override
        public int getLength() {
            return 0;
        }
    };
    private FrescoZoomImageView frescoZoomImageView;
    private static final String IMG_URL = "https://avatars1.githubusercontent.com/u/8758713?v=3&s=460";

    @Before
    public void setup() {
        Context context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        frescoZoomImageView = new FrescoZoomImageView(context, attrSet);
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("com.lhh.frescoimageview.demo", actualBundleName);
    }

    @Test
    public void testAnim() {
        assertTrue(frescoZoomImageView.isAnim());
        frescoZoomImageView.setAnim(false);
        assertFalse(frescoZoomImageView.isAnim());
    }

    @Test
    public void testAutoRotateEnabled() {
        assertFalse(frescoZoomImageView.getAutoRotateEnabled());
        frescoZoomImageView.setAutoRotateEnabled(true);
        assertTrue(frescoZoomImageView.getAutoRotateEnabled());
    }

    @Test
    public void testTapToRetryEnabled() {
        assertFalse(frescoZoomImageView.getTapToRetryEnabled());
        frescoZoomImageView.setTapToRetryEnabled(true);
        assertTrue(frescoZoomImageView.getTapToRetryEnabled());
    }

    @Test
    public void testDefaultResId() {
        frescoZoomImageView.loadView(IMG_URL, 5);
        assertEquals(5, frescoZoomImageView.getDefaultResId());
    }

    @Test
    public void testPostprocessor() {
        Postprocessor postProcessor = null;
        frescoZoomImageView.setPostProcessor(postProcessor);
        assertEquals(postProcessor, frescoZoomImageView.getPostProcessor());
    }

    @Test
    public void testControllerListener() {
        ControllerListener controllerListener = null;
        frescoZoomImageView.setControllerListener(controllerListener);
        assertEquals(controllerListener, frescoZoomImageView.getControllerListener());
    }


    @Test
    public void testThumbnailUrl() {
        frescoZoomImageView.loadView(IMG_URL, IMG_URL, 0);
        assertEquals(IMG_URL, frescoZoomImageView.getThumbnailUrl());
    }

    @Test
    public void testLowThumbnailUrl() {
        frescoZoomImageView.loadView(IMG_URL, IMG_URL, 0);
        assertEquals(IMG_URL, frescoZoomImageView.getLowThumbnailUrl());
    }

    @Test
    public void testAsCircle() {
        RoundingParams roundingParams = frescoZoomImageView.getRoundingParams();
        roundingParams.setRoundAsCircle(true);
        frescoZoomImageView.asCircle();
        assertEquals(roundingParams, frescoZoomImageView.getRoundingParams());
    }
}
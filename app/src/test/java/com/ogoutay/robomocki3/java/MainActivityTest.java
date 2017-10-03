package com.ogoutay.robomocki3.java;

import com.ogoutay.robomocki3.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by ogoutay on 10/3/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, packageName = BuildConfig.APPLICATION_ID)
public class MainActivityTest {

    @Test
    public void testMainActivity() {

    }

}

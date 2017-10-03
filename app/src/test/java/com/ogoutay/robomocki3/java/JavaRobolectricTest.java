package com.ogoutay.robomocki3.java;

import com.netflix.mediaclient.kotlinx.ReflectKt;
import com.ogoutay.robomocki3.BuildConfig;

import org.joor.Reflect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, packageName = BuildConfig.APPLICATION_ID)
public class JavaRobolectricTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testReflection() throws Exception {
        assertEquals(false, false);
        ReflectKt.setFinalStatic(Reflect.on(Boolean.class), "FALSE", true);
        assertEquals(true, false);
    }

    @Test
    public void testMockito() {

    }

}
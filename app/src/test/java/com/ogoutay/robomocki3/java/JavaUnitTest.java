package com.ogoutay.robomocki3.java;

import com.netflix.mediaclient.kotlinx.ReflectKt;

import org.joor.Reflect;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JavaUnitTest {

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

}
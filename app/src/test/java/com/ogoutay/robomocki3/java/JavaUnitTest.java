package com.ogoutay.robomocki3.java;

import com.netflix.mediaclient.kotlinx.ReflectKt;
import com.ogoutay.robomocki3.managers.ExampleManager;

import org.joor.Reflect;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Example of using the {@link Reflect} library with {@link org.junit.runners.JUnit4}
 */
public class JavaUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testReflection() throws Exception {
        //Reflect on regular fields
        ExampleManager exampleManager = new ExampleManager();
        assertNotSame("toto", exampleManager.getPrivateString());
        Reflect.on(exampleManager).set("mPrivateString", "toto");
        assertEquals("toto", exampleManager.getPrivateString());

        //Reflect on private final static
        assertEquals(false, false);
        ReflectKt.setFinalStatic(Reflect.on(Boolean.class), "FALSE", true);
        assertEquals(true, false);
    }

}
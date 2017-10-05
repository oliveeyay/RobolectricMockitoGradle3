package com.ogoutay.robomocki3.kotlin

import com.netflix.mediaclient.kotlinx.setFinalStatic
import com.ogoutay.robomocki3.BuildConfig
import com.ogoutay.robomocki3.managers.ExampleManager
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotSame
import org.joor.Reflect
import org.junit.Test

/**
 * Example of using the [Reflect] library with [org.junit.runners.JUnit4]
 */
class KotlinUnitTest {

    private val MOJITO = "Mojito!"

    @Test
    fun testRegularUnitTest() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun testReflection() {
        //Reflect on regular fields
        val exampleManager = ExampleManager()
        assertNotSame("toto", exampleManager.privateString)
        Reflect.on(exampleManager).set("mPrivateString", "toto")
        assertEquals("toto", exampleManager.privateString)

        //Reflect on private final static
        assertEquals(true, BuildConfig.DEBUG)
        Reflect.on(BuildConfig::class.java).setFinalStatic("DEBUG", false)
        assertEquals(false, BuildConfig.DEBUG)
    }

}
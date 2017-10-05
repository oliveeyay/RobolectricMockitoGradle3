package com.ogoutay.robomocki3.kotlin

import com.netflix.mediaclient.kotlinx.setFinalStatic
import com.ogoutay.robomocki3.BuildConfig
import org.joor.Reflect
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class KotlinUnitTest {

    private val MOJITO = "Mojito!"

    @Test
    fun testRegularUnitTest() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun testReflection() {
        assertEquals(true, BuildConfig.DEBUG)
        Reflect.on(BuildConfig::class.java).setFinalStatic("DEBUG", false)
        assertEquals(false, BuildConfig.DEBUG)
    }

}
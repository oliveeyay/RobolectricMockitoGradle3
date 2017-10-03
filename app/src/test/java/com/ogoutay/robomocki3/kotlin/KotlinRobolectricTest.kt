package com.ogoutay.robomocki3.kotlin

import com.netflix.mediaclient.kotlinx.setFinalStatic
import com.ogoutay.robomocki3.BuildConfig
import org.joor.Reflect
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

import org.junit.Assert.assertEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21), packageName = BuildConfig.APPLICATION_ID)
class KotlinRobolectricTest {

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

    @Test
    fun testMockito() {

    }

}
package com.ogoutay.robomocki3.kotlin

import com.ogoutay.robomocki3.BuildConfig
import org.joor.Reflect
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21), packageName = BuildConfig.APPLICATION_ID)
class MainActivityTest {

    @Test
    fun testMainActivity() {

    }

}
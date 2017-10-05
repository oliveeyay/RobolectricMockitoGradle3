package com.ogoutay.robomocki3.kotlin

import android.app.Activity
import android.widget.TextView
import com.ogoutay.robomocki3.BuildConfig
import com.ogoutay.robomocki3.R
import com.ogoutay.robomocki3.activities.MainActivity
import com.ogoutay.robomocki3.manager.ExampleManager
import org.joor.Reflect
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.Robolectric

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21), packageName = BuildConfig.APPLICATION_ID)
class MainActivityTest {

    companion object {
        private const val MOCKED_VALUE = "toto"
    }

    private lateinit var activity: Activity
    private lateinit var mockExampleManager: ExampleManager

    @Before
    fun setUp() {
        //Building the activity
        val activityController = Robolectric.buildActivity(MainActivity::class.java)

        //Mocking ExampleManager within the Activity
        mockExampleManager = Mockito.mock(ExampleManager::class.java)
        Mockito.`when`(mockExampleManager.serviceName).thenReturn(MOCKED_VALUE)
        Reflect.on(activityController.get()).set("mExampleManager", mockExampleManager)

        //Launching the Activity
        activityController.setup()
        activity = activityController.get()
    }

    @Test
    fun testMainActivity() {
        //Verify this method has been called
        Mockito.verify(mockExampleManager).serviceName

        //Assert the TextView has the mocked value
        Assert.assertEquals(MOCKED_VALUE, activity.findViewById<TextView>(R.id.textView).text)
    }

}
package com.ogoutay.robomocki3.kotlin

import android.app.Activity
import android.widget.TextView
import com.ogoutay.robomocki3.BuildConfig
import com.ogoutay.robomocki3.R
import com.ogoutay.robomocki3.activities.MainActivity
import com.ogoutay.robomocki3.managers.ExampleManager
import junit.framework.Assert.assertEquals
import org.joor.Reflect
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Demonstrates how to spy on an object
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21), packageName = BuildConfig.APPLICATION_ID)
class MainActivitySpyTest {

    companion object {
        private const val MOCKED_VALUE = "toto"
    }

    private lateinit var activity: Activity

    @Spy
    private lateinit var spyExampleManager: ExampleManager

    @Before
    fun setUp() {
        //Building the activity
        val activityController = Robolectric.buildActivity(MainActivity::class.java)

        //Mocking ExampleManager within the Activity
        MockitoAnnotations.initMocks(this)
        Reflect.on(activityController.get()).set("mExampleManager", spyExampleManager)

        //Launching the Activity
        activityController.setup()
        activity = activityController.get()
    }

    @Test
    fun testMainActivity() {
        //Verify this method has been called
        Mockito.verify(spyExampleManager).serviceName

        //Using ArgumentCaptor to capture arguments, and then asserting
        val argumentCaptor = ArgumentCaptor.forClass(String::class.java)
        Mockito.verify(spyExampleManager).setString(argumentCaptor.capture())
        assertEquals(MainActivity.TAG, argumentCaptor.value)

        //Assert the TextView has the real value
        assertEquals(ExampleManager().serviceName, activity.findViewById<TextView>(R.id.textView).text)
    }

}
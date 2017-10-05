package com.ogoutay.robomocki3.kotlin

import android.app.Activity
import android.view.View
import com.ogoutay.robomocki3.BuildConfig
import com.ogoutay.robomocki3.R
import com.ogoutay.robomocki3.activities.MainActivity
import com.ogoutay.robomocki3.interfaces.ManagerCallback
import com.ogoutay.robomocki3.managers.ExampleManager
import junit.framework.Assert
import org.joor.Reflect
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by ogoutay on 10/3/17.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21), packageName = BuildConfig.APPLICATION_ID)
class MainActivityMockVoidTest {

    private lateinit var activity: Activity

    @Mock
    private lateinit var mockExampleManager: ExampleManager

    @Before
    fun setUp() {
        //Building the activity
        val activityController = Robolectric.buildActivity(MainActivity::class.java)

        //Mocking ExampleManager within the Activity
        mockExampleManager = Mockito.mock(ExampleManager::class.java)
        Mockito.doAnswer {
            it.getArgument<ManagerCallback>(0).onVisibilityFetched(View.GONE)
        }.`when`<ExampleManager>(mockExampleManager).fetchVisibility(ArgumentMatchers.isA(ManagerCallback::class.java))
        Reflect.on(activityController.get()).set("mExampleManager", mockExampleManager)

        //Launching the Activity
        activityController.setup()
        activity = activityController.get()
    }

    @Test
    fun testMainActivity() {
        //Assert the TextView text color is GONE in this case
        Assert.assertEquals(View.GONE, activity.findViewById<View>(R.id.textView).visibility)
    }

}

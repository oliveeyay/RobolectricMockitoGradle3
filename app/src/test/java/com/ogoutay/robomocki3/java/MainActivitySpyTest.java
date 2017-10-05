package com.ogoutay.robomocki3.java;

import android.app.Activity;
import android.widget.TextView;

import com.ogoutay.robomocki3.BuildConfig;
import com.ogoutay.robomocki3.R;
import com.ogoutay.robomocki3.activities.MainActivity;
import com.ogoutay.robomocki3.managers.ExampleManager;

import org.joor.Reflect;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Demonstrates how to spy on an object
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, packageName = BuildConfig.APPLICATION_ID)
public class MainActivitySpyTest {

    private Activity activity;

    @Spy
    private ExampleManager spyExampleManager;

    @Before
    public void setUp() {
        //Building the activity
        ActivityController<MainActivity> activityController = Robolectric.buildActivity(MainActivity.class);

        //Mocking ExampleManager within the Activity
        spyExampleManager = Mockito.spy(ExampleManager.class);
        Reflect.on(activityController.get()).set("mExampleManager", spyExampleManager);

        //Launching the Activity
        activityController.setup();
        activity = activityController.get();
    }

    @Test
    public void testMainActivity() {
        //Verify this method has been called
        Mockito.verify(spyExampleManager).getServiceName();

        //Assert the TextView has the real value
        assertEquals(new ExampleManager().getServiceName(), ((TextView) activity.findViewById(R.id.textView)).getText());
    }

}

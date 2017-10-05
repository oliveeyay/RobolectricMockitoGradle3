package com.ogoutay.robomocki3.java;

import android.app.Activity;
import android.view.View;

import com.ogoutay.robomocki3.BuildConfig;
import com.ogoutay.robomocki3.R;
import com.ogoutay.robomocki3.activities.MainActivity;
import com.ogoutay.robomocki3.interfaces.ManagerCallback;
import com.ogoutay.robomocki3.managers.ExampleManager;

import org.joor.Reflect;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Demonstrates how to mock a void method, and use its arguments
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, packageName = BuildConfig.APPLICATION_ID)
public class MainActivityMockVoidTest {

    private Activity activity;

    @Mock
    private ExampleManager mockExampleManager;

    @Before
    public void setUp() {
        //Building the activity
        ActivityController<MainActivity> activityController = Robolectric.buildActivity(MainActivity.class);

        //Mocking ExampleManager within the Activity
        mockExampleManager = Mockito.mock(ExampleManager.class);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((ManagerCallback) invocation.getArgument(0)).onVisibilityFetched(View.GONE);
                return null;
            }
        }).when(mockExampleManager).fetchVisibility(ArgumentMatchers.isA(ManagerCallback.class));
        Reflect.on(activityController.get()).set("mExampleManager", mockExampleManager);

        //Launching the Activity
        activityController.setup();
        activity = activityController.get();
    }

    @Test
    public void testMainActivity() {
        //Assert the TextView text color is GONE in this case
        assertEquals(View.GONE, activity.findViewById(R.id.textView).getVisibility());
    }

}

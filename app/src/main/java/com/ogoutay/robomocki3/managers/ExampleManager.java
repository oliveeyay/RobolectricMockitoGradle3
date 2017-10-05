package com.ogoutay.robomocki3.managers;

import android.support.annotation.NonNull;
import android.view.View;

import com.ogoutay.robomocki3.interfaces.ManagerCallback;

/**
 * Created by ogoutay on 10/3/17.
 */
public final class ExampleManager {

    private static final String SERVICE_NAME = "SERVICE_NAME";

    public ExampleManager() {
    }

    public String getServiceName() {
        return SERVICE_NAME;
    }

    public void fetchVisibility(@NonNull ManagerCallback managerCallback) {
        managerCallback.onVisibilityFetched(View.VISIBLE);
    }

}

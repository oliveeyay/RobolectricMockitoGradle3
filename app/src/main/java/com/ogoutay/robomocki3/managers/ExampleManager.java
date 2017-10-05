package com.ogoutay.robomocki3.managers;

import android.support.annotation.NonNull;
import android.view.View;

import com.ogoutay.robomocki3.interfaces.ManagerCallback;

/**
 * Just a manager example, for reflection/mock purpose
 */
public final class ExampleManager {

    private static final String SERVICE_NAME = "SERVICE_NAME";

    private String mPrivateString = "mPrivateString";

    public ExampleManager() {
    }

    public void fetchVisibility(@NonNull ManagerCallback managerCallback) {
        managerCallback.onVisibilityFetched(View.VISIBLE);
    }

    public void setString(String string) {
        //No-op, just for argument captors example
    }

    public String getServiceName() {
        return SERVICE_NAME;
    }

    public String getPrivateString() {
        return mPrivateString;
    }

}

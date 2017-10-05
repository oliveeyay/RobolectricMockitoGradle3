package com.ogoutay.robomocki3.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ogoutay.robomocki3.R;
import com.ogoutay.robomocki3.interfaces.ManagerCallback;
import com.ogoutay.robomocki3.managers.ExampleManager;

public class MainActivity extends AppCompatActivity implements ManagerCallback {

    private TextView mTextView;

    private final ExampleManager mExampleManager = new ExampleManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mTextView.setText(mExampleManager.getServiceName());
        mExampleManager.fetchVisibility(this);
    }

    @Override
    public void onVisibilityFetched(int visibility) {
        mTextView.setVisibility(visibility);
    }

}

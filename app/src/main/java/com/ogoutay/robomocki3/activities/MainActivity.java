package com.ogoutay.robomocki3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ogoutay.robomocki3.R;
import com.ogoutay.robomocki3.manager.ExampleManager;

public class MainActivity extends AppCompatActivity {

    private final ExampleManager mExampleManager = new ExampleManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ((TextView) findViewById(R.id.textView)).setText(mExampleManager.getServiceName());
    }
}

package com.yuan.testappbar.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void tip(String tipStr) {
        Toast.makeText(this, tipStr, Toast.LENGTH_SHORT).show();
    }
}

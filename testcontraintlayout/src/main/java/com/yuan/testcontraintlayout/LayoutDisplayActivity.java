package com.yuan.testcontraintlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LayoutDisplayActivity extends AppCompatActivity {
    private static final String TAG = LayoutDisplayActivity.class.getSimpleName();
    static final String EXTRA_LAYOUT_ID = TAG + ".layoutId"; // 布局ID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getIntent().getStringExtra(Intent.EXTRA_TITLE));
        final int layoutId = getIntent().getIntExtra(EXTRA_LAYOUT_ID, 0);
        setContentView(layoutId); // 设置页面布局, 复用布局
    }
}

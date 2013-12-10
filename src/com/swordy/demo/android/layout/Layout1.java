package com.swordy.demo.android.layout;

import android.app.Activity;
import android.os.Bundle;

import com.swordy.demo.android.R;

public class Layout1 extends Activity
{
    private static final String TAG = "AndroidDemos.Layout1";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
    }
}

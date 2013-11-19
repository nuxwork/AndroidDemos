package com.swordy.demo.android.library.widget;

import android.app.Activity;
import android.os.Bundle;

import com.swordy.demo.android.R;

public class Switcher1 extends Activity
{
    public static final String TAG = Switcher1.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_switcher1);
    }
}

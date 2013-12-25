package com.swordy.demo.android.library.util;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.swordy.demo.android.R;
import com.swordy.library.android.util.DrawableUtil;

public class DrawableUtil1 extends Activity
{
    private static final String TAG = "AndroidDemos.DrawableUtil1";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_drawableutil1);
        
        DrawableUtil.addDrawableTracker(0xfe01);
        DrawableUtil.setCurrentTrackerId(0xfe01);
        ImageView iv = (ImageView)findViewById(R.id.imageView1);
        iv.setImageDrawable(DrawableUtil.getDrawable(getResources(), R.drawable.regiontouch1_keyboard_bg));
        iv.setOnTouchListener(new OnTouchListener()
        {
            
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                Log.v(TAG, "view on touch");
                return true;
            }
        });
    }
    
    @Override
    protected void onResume()
    {
        Log.v(TAG, "onResume");
        super.onResume();
    }
    
    @Override
    protected void onRestart()
    {
        Log.v(TAG, "onRestart");
        super.onRestart();
    }
    
    @Override
    protected void onPause()
    {
        Log.v(TAG, "onPause");
        super.onPause();
    }
    
    @Override
    protected void onStop()
    {
        Log.v(TAG, "onStop");
        super.onStop();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        Log.v(TAG, "activity on Touch");
        //        return super.onTouchEvent(event);
        return true;
    }
    
    @Override
    protected void onDestroy()
    {
        Log.v(TAG, "onDestroy");
        DrawableUtil.recycle(0xfe01);
        super.onDestroy();
    }
    
}

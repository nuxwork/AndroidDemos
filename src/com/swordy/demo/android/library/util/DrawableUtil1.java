package com.swordy.demo.android.library.util;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.swordy.demo.android.R;
import com.swordy.library.android.util.DrawableUtil;

public class DrawableUtil1 extends Activity
{
    private static final String TAG = "AndroidDemos.DrawableUtil1";
    
    private Button mBtn1;
    
    private Button mBtn2;
    
    private Button mBtn3;
    
    private boolean mIsLoad1;
    
    private boolean mIsLoad2;
    
    private boolean mIsLoad3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_drawableutil1);
        
        mBtn1 = (Button)findViewById(R.id.button1);
        mBtn2 = (Button)findViewById(R.id.button2);
        mBtn3 = (Button)findViewById(R.id.button3);
    }
    
    public void onButtonClicked(View v)
    {
        int id = v.getId();
        switch (id)
        {
            case R.id.button1:
                if (!mIsLoad1)
                {
                    mIsLoad1 = true;
                    mBtn1.setBackgroundDrawable(DrawableUtil.getDrawable(this, R.drawable.number_1));
                }
                else
                {
                    DrawableUtil.recycle(this);
                }
                break;
            case R.id.button2:
                if (!mIsLoad2)
                {
                    mIsLoad2 = true;
                    mBtn2.setBackgroundDrawable(DrawableUtil.getDrawable(this, R.drawable.number_2));
                }
                else
                {
                    DrawableUtil.recycle(this);
                }
                
                break;
            case R.id.button3:
                if (!mIsLoad3)
                {
                    mIsLoad3 = true;
                    mBtn3.setBackgroundDrawable(DrawableUtil.getDrawable(getApplicationContext(), R.drawable.number_2));
                }
                else
                {
                    DrawableUtil.recycle(getApplicationContext());
                }
                
                break;
            
            default:
                break;
        }
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
        DrawableUtil.recycleAll();
        super.onDestroy();
    }
    
}

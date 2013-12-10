package com.swordy.demo.android.library.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.swordy.demo.android.R;
import com.swordy.library.android.view.FlingDetector;
import com.swordy.library.android.view.FlingDetector.OnFlingListener;

public class FlingDetector1 extends Activity
{
    private static final String TAG = "AndroidDemos.FlingDectector1";
    
    private TextView mTxvDeretion;
    
    private FlingDetector mFlingDetector;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_flingdetector1);
        
        mFlingDetector = new FlingDetector(this, mFlingListener);
        
        mTxvDeretion = (TextView)findViewById(R.id.textView1);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        mFlingDetector.detect(null, event);
        return super.onTouchEvent(event);
    }
    
    private OnFlingListener mFlingListener = new OnFlingListener()
    {
        
        @Override
        public void onDown(View v, float x, float y)
        {
            // TODO Auto-generated method stub
            return;
        }
        
        @Override
        public void onUp(View v, float x, float y)
        {
            // TODO Auto-generated method stub
            return;
        }
        
        @Override
        public void onPress(View v, float x, float y)
        {
            // TODO Auto-generated method stub
            return;
        }
        
        @Override
        public void onMove(View v, float x, float y)
        {
            // TODO Auto-generated method stub
            return;
        }
        
        @Override
        public void onClick(View v, float x, float y)
        {
            // TODO Auto-generated method stub
            return;
        }
        
        @Override
        public void onFling(View v, int direction)
        {
            // TODO Auto-generated method stub
            return;
        }
        
        @Override
        public void onSerialFling(View v, int direction)
        {
            // TODO Auto-generated method stub
            return;
        }
        
    };
}

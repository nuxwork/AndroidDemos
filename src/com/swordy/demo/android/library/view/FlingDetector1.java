package com.swordy.demo.android.library.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
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
        mFlingDetector.detect(event);
        return super.onTouchEvent(event);
    }
    
    private OnFlingListener mFlingListener = new OnFlingListener()
    {
        
        @Override
        public void onFling(int direction)
        {
            switch (direction)
            {
                case FlingDetector.SINGLE_TAP:
                    mTxvDeretion.setText("SINGLE_TAP");
                    break;
                case FlingDetector.FLING_UP:
                    mTxvDeretion.setText("FLING_UP");
                    break;
                case FlingDetector.FLING_DOWN:
                    mTxvDeretion.setText("FLING_DOWN");
                    break;
                case FlingDetector.FLING_LEFT:
                    mTxvDeretion.setText("FLING_LEFT");
                    break;
                case FlingDetector.FLING_RIGHT:
                    mTxvDeretion.setText("FLING_RIGHT");
                    break;
            }
        }
    };
}

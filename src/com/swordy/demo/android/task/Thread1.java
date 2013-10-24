package com.swordy.demo.android.task;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.swordy.demo.android.R;

public class Thread1 extends Activity
{
    public static final String TAG = Thread1.class.getSimpleName();
    
    private static final int STATE_PREPERD = 0;
    
    private static final int STATE_STARTED = 1;
    
    private static final int STATE_PAUSED = 2;
    
    private static final int STATE_STOPED = 3;
    
    private TextView mTextView;
    
    private int mNumber = 0;
    
    private int mState = STATE_PREPERD;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread1);
        
        mTextView = (TextView)findViewById(R.id.textView1);
        mThread.start();
    }
    
    @Override
    protected void onResume()
    {
        if (mState == STATE_PAUSED)
            mState = STATE_STARTED;
        super.onResume();
    }
    
    @Override
    protected void onPause()
    {
        mState = STATE_PAUSED;
        super.onPause();
    }
    
    @Override
    protected void onDestroy()
    {
        mState = STATE_STOPED;
        super.onDestroy();
    }
    
    public void onViewClicked(View v)
    {
        switch (v.getId())
        {
            case R.id.button1:
                mState = STATE_STARTED;
                break;
            case R.id.button2:
                mState = STATE_PAUSED;
                break;
            case R.id.button3:
                mState = STATE_STOPED;
                break;
        }
    }
    
    private Handler mHandler = new Handler()
    {
        
        @Override
        public void handleMessage(Message msg)
        {
            mTextView.setText("数字：" + mNumber);
        }
        
    };
    
    private Thread mThread = new Thread()
    {
        
        @Override
        public void run()
        {
            while (mState != STATE_STOPED)
            {
                if (mState == STATE_PAUSED)
                    continue;
                
                mNumber++;
                mHandler.sendEmptyMessage(0);
                
                // sleep must behind the real task
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
    };
}

package com.swordy.demo.android.task;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.swordy.demo.android.R;

public class Thread2 extends Activity
{
    public static final String TAG = Thread2.class.getSimpleName();
    
    private static final int STATE_PREPERD = 0;
    
    private static final int STATE_STARTED = 1;
    
    private static final int STATE_PAUSED = 2;
    
    private static final int STATE_STOPED = 3;
    
    private TextView mTextView;
    
    private int mNumber = 0;
    
    private int mState = STATE_PREPERD;
    
    private Toast mToast;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread1);
        
        mTextView = (TextView)findViewById(R.id.textView1);
        new LooperThread().start();
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
    
    private class LooperThread extends Thread
    {
        
        public LooperThread()
        {
            
        }
        
        @Override
        public void run()
        {
            Looper.prepare();
            mToast = Toast.makeText(getApplicationContext(), "开始" + mNumber, 1);
            mToast.show();

            while (mState != STATE_STOPED)
            {
                if (mState == STATE_PAUSED)
                    continue;
                
                mNumber++;
                mHandler.sendEmptyMessage(0);
                Looper.loop();
                mToast.setText("数字" + mNumber);
                Log.v(TAG, "log 数字 " + mNumber);
                mToast.show();
                
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            mHandler.getLooper().quit();
        }
        
    };
}

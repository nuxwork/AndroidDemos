package com.swordy.demo.android.task;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
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
        
        HandlerThread t = new HandlerThread("my");
        t.start();
        Handler h2 = new MyHandler(t.getLooper());
        h2.sendEmptyMessage(0);
    }
    
    @Override
    protected void onResume()
    {
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
    
    private class MyHandler extends Handler
    {
        
        public MyHandler()
        {
            super();
        }
        public MyHandler(Looper l)
        {
            super(l);
        }
        
        @Override
        public void handleMessage(Message msg)
        {
            showThread();
            mTextView.setText("数字：" + mNumber);
        }
        
    };
    
    private MyHandler mMyHandler;
    
    private class LooperThread extends HandlerThread
    {
        
        public LooperThread(String name)
        {
            super(name);
        }
        
        @Override
        public void run()
        {
            while (mState != STATE_STOPED)
            {
                Log.v(TAG, "running...");
                if (mState == STATE_PAUSED)
                {
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    continue;
                }
                
                mNumber++;
                mMyHandler.sendEmptyMessage(0);
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
    
    private void showThread()
    {
        Thread thr = Thread.currentThread();
        Log.v(TAG, "" + thr.getName() + "  " + thr.getId() + "  " + thr.getState());
    }
}

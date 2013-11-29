package com.swordy.demo.android.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;

import com.swordy.demo.android.R;

public class SurfaceView1 extends Activity
{
    private static final String TAG = "AndroidDemos.SurfaceView1";
    
    private SurfaceView mSurfaceView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surfaceview1);
        mSurfaceView = (SurfaceView)findViewById(R.id.surfaceView1);
        mSurfaceView.getHolder().addCallback(mCallback);
    }
    
    @Override
    protected void onResume()
    {
        Log.v(TAG, "onResume");
        super.onResume();
    }
    
    @Override
    protected void onStart()
    {
        Log.v(TAG, "onStart");
        super.onStart();
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
    protected void onDestroy()
    {
        Log.v(TAG, "onDestroy");
        super.onDestroy();
    };
    
    private Callback mCallback = new Callback()
    {
        
        @Override
        public void surfaceDestroyed(SurfaceHolder holder)
        {
            Log.v(TAG, "surfaceDestroyed");
        }
        
        @Override
        public void surfaceCreated(SurfaceHolder holder)
        {
            Log.v(TAG, "surfaceCreated");
            
        }
        
        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
        {
            Log.v(TAG, "surfaceChanged");
            
        }
    };
    
    public void onButtonClick(View v){
        new AlertDialog.Builder(this).setTitle("dialog").create().show();
    }
}

package com.swordy.demo.android.widget;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.VideoView;

import com.swordy.demo.android.R;

public class VideoView1 extends Activity
{
    public static final String TAG = VideoView1.class.getSimpleName();
    
    private VideoView mVideoView;
    
    private SeekBar mSeekBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview1);
        
        mVideoView = (VideoView)findViewById(R.id.videoView1);
        mSeekBar = (SeekBar)findViewById(R.id.seekBar1);
        mSeekBar.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
        
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setVideoPath("/sdcard/video/loveSick.mp4");
        mThread.start();
        
    }
    
    @Override
    protected void onResume()
    {
        super.onResume();
        mVideoView.start();
    }
    
    @Override
    protected void onPause()
    {
        mVideoView.pause();
        super.onPause();
    }
    
    @Override
    protected void onStop()
    {
        super.onStop();
    }
    
    @Override
    protected void onDestroy()
    {
        if (mVideoView.isPlaying())
            mVideoView.stopPlayback();
        mVideoView.suspend();
        super.onDestroy();
    }
    
    private Handler mHandler = new Handler()
    {
        
        @Override
        public void handleMessage(Message msg)
        {
            int progress = (mVideoView.getCurrentPosition() * mSeekBar.getMax() / mVideoView.getDuration());
            mSeekBar.setProgress(progress);
        }
        
    };
    
    private Thread mThread = new Thread()
    {
        
        @Override
        public void run()
        {
            while (mVideoView != null)
            {
                if (mVideoView.isPlaying())
                {
                    mHandler.sendEmptyMessage(0);
                }
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
    
    public void onViewClicked(View v)
    {
        switch (v.getId())
        {
            case R.id.imageButton1:
                if (mVideoView.isPlaying())
                {
                    mVideoView.pause();
                }
                else
                {
                    mVideoView.start();
                }
                break;
        }
    }
    
    private OnSeekBarChangeListener mOnSeekBarChangeListener = new OnSeekBarChangeListener()
    {
        
        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {
            int ratio = (int)(mVideoView.getDuration() / 100f);
            mVideoView.seekTo(seekBar.getProgress() * ratio);
        }
        
        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {
            
        }
        
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            
        }
    };
    
}

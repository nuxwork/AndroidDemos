package com.swordy.demo.android.media;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.swordy.demo.android.R;

public class MediaPlayer1 extends Activity
{
    public static final String TAG = MediaPlayer1.class.getSimpleName();
    
    private MediaPlayer mMediaPlayer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaplayer1);
    }
    
    public void onClicked(View v)
    {
        switch (v.getId())
        {
            case R.id.button1:
                //mMediaPlayer = MediaPlayer.create(this, R.raw.love_sick);
                mMediaPlayer = MediaPlayer.create(this, Uri.fromFile(new File("/sdcard/video/loveSick.mp4")));
                try
                {
                    mMediaPlayer.prepare();
                }
                catch (IllegalStateException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case R.id.button2:
                mMediaPlayer.start();
                break;
            case R.id.button3:
                mMediaPlayer.pause();
                break;
            case R.id.button4:
                mMediaPlayer.stop();
                break;
        }
    }
}

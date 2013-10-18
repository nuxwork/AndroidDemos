package com.swordy.demo.android.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.swordy.demo.android.R;
import com.swordy.demo.android.widget.GridView3;

public class Animation1 extends Activity
{
	private static final String TAG = Animation1.class.getSimpleName();
	
    private ImageView mImgSpeechWave;
    
    private AnimationDrawable mAnimSpeechWave;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation1);
        
        mImgSpeechWave = (ImageView)findViewById(R.id.animation1_imgSpeechWave);
        mImgSpeechWave.setBackgroundResource(R.anim.animation1_drawable_list);
        mAnimSpeechWave = (AnimationDrawable)mImgSpeechWave.getBackground();
    }
    
    public void onSpeechWaveClicked(View v)
    {
        Log.v("Animation1", "dian j");
        if (!mAnimSpeechWave.isRunning())
            mAnimSpeechWave.start();
        else
            mAnimSpeechWave.stop();
    }
    
}

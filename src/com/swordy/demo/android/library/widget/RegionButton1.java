package com.swordy.demo.android.library.widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.swordy.demo.android.R;
import com.swordy.library.android.util.DrawableUtil;
import com.swordy.library.android.widget.RegionButton;
import com.swordy.library.android.widget.RegionButton.OnRegionClickListener;
import com.swordy.library.android.widget.RegionButton.OnRegionLongClickListener;
import com.swordy.library.android.widget.RegionButton.OnRegionTouchListener;

public class RegionButton1 extends Activity
{
    public static final String TAG = RegionButton1.class.getSimpleName();
    
    private static final int COLOR_DIRETION_OK = 0xFFFF0000;
    
    private static final int COLOR_DIRETION_UP = 0xFF00FF00;
    
    private static final int COLOR_DIRETION_DOWN = 0xFF0000FF;
    
    private static final int COLOR_DIRETION_LEFT = 0xFFFF00FF;
    
    private static final int COLOR_DIRETION_RIGHT = 0xFF00FFFF;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_regionbutton1);
        
        RegionButton rb = (RegionButton)findViewById(R.id.regionButton1);
        rb.setBackgroundDrawable(DrawableUtil.getDrawable(getResources(), R.drawable.regiontouch1_keyboard_bg));
        rb.setRegionMap(R.drawable.regiontouch1_keyboard_region, new int[] {COLOR_DIRETION_OK, COLOR_DIRETION_UP,
            COLOR_DIRETION_DOWN, COLOR_DIRETION_LEFT, COLOR_DIRETION_RIGHT}, new int[] {
            R.drawable.regiontouch1_keyboard_ok_pressed, R.drawable.regiontouch1_keyboard_up_pressed,
            R.drawable.regiontouch1_keyboard_down_pressed, R.drawable.regiontouch1_keyboard_left_pressed,
            R.drawable.regiontouch1_keyboard_right_pressed,});
        
        rb.setOnRegionClickListener(new OnRegionClickListener()
        {
            
            @Override
            public void onRegionClick(RegionButton v, int id)
            {
                Log.v(TAG, "onRegionClick,  id: " + Integer.toHexString(id).toString());
            }
            
        });
        
        rb.setOnRegionLongClickListener(new OnRegionLongClickListener()
        {
            
            @Override
            public void onRegionLongClick(RegionButton v, int id)
            {
                Log.v(TAG, "onRegionLongClick,  id: " + Integer.toHexString(id).toString());
            }
        });
        rb.setOnRegionTouchListener(new OnRegionTouchListener()
        {
            
            @Override
            public boolean onRegionTouch(RegionButton v, int id, MotionEvent event)
            {
                Log.v(TAG, "onRegionTouch &&&&,  id: " + Integer.toHexString(id).toString());
                return false;
            }
        });
        
    }
}

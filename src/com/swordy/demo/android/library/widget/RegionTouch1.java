package com.swordy.demo.android.library.widget;

import android.app.Activity;
import android.os.Bundle;

import com.swordy.demo.android.R;
import com.swordy.library.android.widget.RegionTouch;

public class RegionTouch1 extends Activity
{
    public static final String TAG = RegionTouch1.class.getSimpleName();
    
    private static final int COLOR_DIRETION_OK = 0xFFFF0000;
    
    private static final int COLOR_DIRETION_UP = 0xFF00FF00;
    
    private static final int COLOR_DIRETION_DOWN = 0xFF0000FF;
    
    private static final int COLOR_DIRETION_LEFT = 0xFFFF00FF;
    
    private static final int COLOR_DIRETION_RIGHT = 0xFF00FFFF;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_regiontouch1);
        
        RegionTouch rt = (RegionTouch)findViewById(R.id.regionTouch1);
//        rt.setRegionMap(R.drawable.regiontouch1_keyboard_region, new int[] {COLOR_DIRETION_OK, COLOR_DIRETION_UP,
//            COLOR_DIRETION_DOWN, COLOR_DIRETION_LEFT, COLOR_DIRETION_RIGHT}, new int[] {
//            R.drawable.regiontouch1_keyboard_ok_pressed, R.drawable.regiontouch1_keyboard_up_pressed,
//            R.drawable.regiontouch1_keyboard_down_pressed, R.drawable.regiontouch1_keyboard_left_pressed,
//            R.drawable.regiontouch1_keyboard_right_pressed});
    }
    
}

package com.swordy.demo.android.app;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import com.swordy.demo.android.R;

public class Dialog2 extends Activity
{
    private static final String TAG = "AndroidDemos.Dialog2";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog2);
    }
    
    public void onButtonClick(View v)
    {
        View item = View.inflate(this, R.layout.dialog2_item, null);
        //        AlertDialog a = new AlertDialog.Builder(this).setView(item).create();
        //        a.getWindow().setBackgroundDrawableResource(R.drawable.layer);
        //        a.getWindow().setLayout(-1, -1);
        //        a.show();
        
        PopupWindow pop = new PopupWindow(item, -1, -1, true);
        pop.setContentView(item);
        pop.setBackgroundDrawable(new ColorDrawable(0x88000000));
        pop.showAtLocation(getWindow().getDecorView(), Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 0);
    }
}

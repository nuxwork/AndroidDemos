package com.swordy.demo.android.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.swordy.demo.android.R;

@SuppressLint("NewApi")
public class DragAndDrop1 extends Activity
{
    private static final String TAG = DragAndDrop1.class.getSimpleName();
    
    private ImageView mImgMic;
    
    private LinearLayout mLayContainer;
    
    private RelativeLayout mLayRoot;
    
    private Toast mToast;
    
    private Point mDragPoint = new Point(-1, -1);
    
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_and_drop1);
        
        mToast = Toast.makeText(this, "", Toast.LENGTH_LONG);
        
        mLayContainer = (LinearLayout)findViewById(R.id.layout2);
        mLayRoot = (RelativeLayout)findViewById(R.id.layout1);
        mImgMic = (ImageView)findViewById(R.id.imageView1);
        
        mImgMic.setOnLongClickListener(new OnLongClickListener()
        {
            
            @Override
            public boolean onLongClick(View v)
            {
                ClipData.Item item = new ClipData.Item("item string");
                ClipData clipdata = new ClipData("img_mic", new String[] {"image/*"}, item);
                DragShadowBuilder shadow = new DragShadowBuilder(mImgMic);
                mImgMic.startDrag(clipdata, shadow, "", 0);
                return true;
            }
        });
        
        mLayContainer.setOnDragListener(new OnDragListener()
        {
            @Override
            public boolean onDrag(View v, DragEvent event)
            {
                switch (event.getAction())
                {
                    case DragEvent.ACTION_DRAG_ENDED:
                        mToast.setText("action drag end");
                        Log.v(TAG, "action drag end");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        mToast.setText("action drag entered");
                        Log.v(TAG, "action drag entered");
                        
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        mToast.setText("action drag exited");
                        Log.v(TAG, "action drag exited");
                        
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        mToast.setText("action drag location");
                        Log.v(TAG, "action drag location");
                        
                        break;
                    case DragEvent.ACTION_DRAG_STARTED:
                        mToast.setText("action drag started");
                        Log.v(TAG, "action drag started");
                        
                        break;
                    case DragEvent.ACTION_DROP:
                        mToast.setText("action drop");
                        Log.v(TAG, "action drop");
                        mLayRoot.removeView(mImgMic);
                        mLayContainer.addView(mImgMic);
                        break;
                }
                mToast.show();
                
                // must return true witch event was handled
                return true;
            }
        });
    }
}

package com.swordy.demo.android.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.swordy.demo.android.R;

@SuppressLint("NewApi")
public class DragAndDrop2 extends Activity
{
    private static final String TAG = DragAndDrop2.class.getSimpleName();
    
    private ImageView mImgMic;
    
    private LinearLayout mLayContainer;
    
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
        mImgMic = (ImageView)findViewById(R.id.imageView1);
        
        mImgMic.setOnLongClickListener(new OnLongClickListener()
        {
            
            @Override
            public boolean onLongClick(View v)
            {
                ClipData.Item item = new ClipData.Item("item string");
                ClipData clipdata = new ClipData("img_mic", new String[] {"image/*"}, item);
                DragShadowBuilder shadow = new MyDragShadowBuilder(mImgMic);
                mImgMic.startDrag(clipdata, shadow, "", 0);
                return true;
            }
        });
        
        mImgMic.setOnTouchListener(new OnTouchListener()
        {
            
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        if (event.getPointerCount() == 1)
                            mDragPoint.set((int)event.getX(), (int)event.getY());
                        return false;
                        
                    default:
                        break;
                }
                return false;
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
                        break;
                }
                mToast.show();
                
                // must return true witch event was handled
                return true;
            }
        });
    }
    
    private class MyDragShadowBuilder extends DragShadowBuilder
    {
        public MyDragShadowBuilder()
        {
            super();
        }
        
        public MyDragShadowBuilder(View v)
        {
            super(v);
        }
        
        @Override
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint)
        {
            final View view = getView();
            if (view != null)
            {
                shadowSize.set(view.getWidth() + 10, view.getHeight() + 10);
                
                Log.v(TAG, "before   point x: " + shadowTouchPoint.x + "  point y: " + shadowTouchPoint.y);
                shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2 - mDragPoint.y);
                Log.v(TAG, "after    point x: " + shadowTouchPoint.x + "  point y: " + shadowTouchPoint.y);
            }
            else
            {
                Log.e(TAG, "Asked for drag thumb metrics but no view");
            }
        }
        
        @Override
        public void onDrawShadow(Canvas canvas)
        {
            super.onDrawShadow(canvas);
        }
        
    }
}

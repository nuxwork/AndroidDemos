package com.swordy.demo.android.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

import com.swordy.demo.android.R;

public class Button1 extends Activity
{
    private static final String TAG = Button1.class.getSimpleName();
    
    private Toast mToast;
    
    private Button mBtnLongClick;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.button1);
        
        mBtnLongClick = (Button)findViewById(R.id.button4);
        mBtnLongClick.setOnLongClickListener(new OnLongClickListener()
        {
            
            @Override
            public boolean onLongClick(View v)
            {
                if (mToast == null)
                {
                    mToast = Toast.makeText(Button1.this, ((Button)v).getText().toString(), Toast.LENGTH_SHORT);
                }
                else
                {
                    mToast.setText(((Button)v).getText().toString());
                }
                
                mToast.show();
                return true;
            }
        });
        mBtnLongClick.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                if (mToast == null)
                {
                    mToast = Toast.makeText(Button1.this, ((Button)v).getText().toString() + " single clicked", Toast.LENGTH_SHORT);
                }
                else
                {
                    mToast.setText(((Button)v).getText().toString() + " single clicked");
                }
                
                mToast.show();
            }
        });
//        mBtnLongClick.setOnTouchListener(new OnTouchListener()
//        {
//            
//            @Override
//            public boolean onTouch(View v, MotionEvent event)
//            {
//                if (mToast == null)
//                {
//                    mToast = Toast.makeText(Button1.this, ((Button)v).getText().toString() + " touched", Toast.LENGTH_SHORT);
//                }
//                else
//                {
//                    mToast.setText(((Button)v).getText().toString() + " touched");
//                }
//                return true;
//            }
//        });
    }
    
    public void onButtonClicked(View v)
    {
        if (mToast == null)
        {
            mToast = Toast.makeText(this, ((Button)v).getText().toString(), Toast.LENGTH_SHORT);
        }
        else
        {
            mToast.setText(((Button)v).getText().toString());
        }
        
        mToast.show();
    }
    
}

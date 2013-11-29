package com.swordy.demo.android.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.swordy.demo.android.R;

public class PopupWindow1 extends Activity implements View.OnClickListener
{
    private static final String TAG = "AndroidDemos.PopupWindow1";
    
    private static final String[] NAMES = {"Google", "Microsoft", "Yahoo", "IBM"};
    
    private PopupWindow mPopupWindow;
    
    private View mAnchor;
    
    private TextView mText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow1);
        
        mAnchor = findViewById(R.id.anchor1);
        mText = (TextView)findViewById(R.id.textView1);
        mPopupWindow = new PopupWindow(this);
        
        ArrayAdapter<String> adapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, NAMES);
        ListView list = new ListView(this);
        list.setAdapter(adapter);
        
        mPopupWindow.setContentView(list);
        mPopupWindow.setWidth(100);
        mPopupWindow.setHeight(300);
        mPopupWindow.setAnimationStyle(R.style.PopupAnimation);
        
        findViewById(R.id.button1).setOnClickListener(this);
    }
    
    @SuppressLint("NewApi")
    @Override
    public void onClick(View v)
    {
        if (mPopupWindow.isShowing())
        {
            mText.setText("dismiss");
            mPopupWindow.dismiss();
        }
        else
        {
            mText.setText("show");
            mPopupWindow.showAsDropDown(mAnchor);
        }
        
    }
    
}

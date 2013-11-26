package com.swordy.demo.android.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.swordy.demo.android.R;

public class ListPopupWindow1 extends Activity implements OnClickListener
{
    private static final String TAG = "AndroidDemos.ListPopupWindow1";
    
    private static final String[] NAMES = {"Google", "Microsoft", "Yahoo", "IBM"};
    
    private ListPopupWindow mListPopupWindow;
    
    private View mAnchor;
    
    private TextView mText;
    
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listpopupwindow1);
        
        mAnchor = findViewById(R.id.anchor1);
        mText = (TextView)findViewById(R.id.textView1);
        mListPopupWindow = new ListPopupWindow(this);
        
        ArrayAdapter<String> adapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, NAMES);
        
        mListPopupWindow.setAdapter(adapter);
        mListPopupWindow.setAnchorView(mAnchor);
        mListPopupWindow.setWidth(100);
        mListPopupWindow.setHeight(300);
        mListPopupWindow.setAnimationStyle(R.style.PopupAnimation);
        
        findViewById(R.id.button1).setOnClickListener(this);
    }
    
    @SuppressLint("NewApi")
    @Override
    public void onClick(View v)
    {
        if (mListPopupWindow.isShowing())
        {
            mText.setText("dismiss");
            mListPopupWindow.dismiss();
        }
        else
        {
            mText.setText("show");
            mListPopupWindow.show();
        }
        
    }
}

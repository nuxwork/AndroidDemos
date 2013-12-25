package com.swordy.demo.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.swordy.demo.android.R;

public class RequestActivity1 extends Activity
{
    private static final String TAG = "AndroidDemos.RequestActivity1";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.requestactivity1);
        
        Button btnRequest = (Button)findViewById(R.id.button1);
        btnRequest.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

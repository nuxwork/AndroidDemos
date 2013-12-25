package com.swordy.demo.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.swordy.demo.android.R;

public class ResultActivity1 extends Activity
{
    private static final String TAG = "AndroidDemos.ResultActivity1";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.resultactivity1);
        
        Button btnRequest = (Button)findViewById(R.id.button1);
        btnRequest.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                Intent newIntent = new Intent(ResultActivity1.this, RequestActivity1.class);
                startActivityForResult(newIntent, 1);
            }
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tv = (TextView)findViewById(R.id.textView1);
        tv.setText("requestCode: " + requestCode + ", resultCode: " + resultCode + ", data: " + data);
    }
}

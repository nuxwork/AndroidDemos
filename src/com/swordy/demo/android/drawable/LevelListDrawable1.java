package com.swordy.demo.android.drawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.swordy.demo.android.R;

public class LevelListDrawable1 extends Activity
{
    public static final String TAG = LevelListDrawable1.class.getSimpleName();
    
    private Spinner mSpinner;
    private ImageView mImgLevel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levellistdrawable1);
        
        mSpinner = (Spinner)findViewById(R.id.spinner1);
        mImgLevel = (ImageView)findViewById(R.id.imageView1);
        
        String[] numbers = new String[12];
        for(int i =0 ; i != 12; i++){
            numbers[i] = ""+i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, numbers);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                mImgLevel.setImageLevel(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                
            }
        });
    }
}

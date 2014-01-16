package com.swordy.demo.android.io;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.View;

import com.swordy.demo.android.R;

public class Raw1 extends Activity
{
    private static final String TAG = "AndroidDemos.Raw1";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raw1);
    }
    
    public void onButtonClicked(View v)
    {
        InputStream is = null;
        OutputStream os = null;
        try
        {
/*            AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.projects);
            FileDescriptor fd = new FileDescriptor();
            
            is = getResources().openRawResource(R.raw.projects);
            os = new FileOutputStream("/sdcard/swordy/projects.mp4");
            int n = -1;
            while ((n = is.read()) != -1)
            {
                os.write(n);
            }
            is.close();
            os.close();*/
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

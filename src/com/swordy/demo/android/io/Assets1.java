package com.swordy.demo.android.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;

import com.swordy.demo.android.R;

public class Assets1 extends Activity
{
    private static final String TAG = "AndroidDemos.Assets1";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assets1);
        
    }
    
    public void onButtonClicked(View v)
    {
        copy();
    }
    
    private void copy()
    {
        AssetManager am = getResources().getAssets();
        InputStream is = null;
        OutputStream os = null;
        try
        {
            is = am.open("projects.mp4");
            os = new FileOutputStream("/sdcard/swordy/projects.mp4", false);
            byte[] buffer = new byte[1024];
            int b = -1;
            while ((b = is.read(buffer)) != -1)
            {
//                os.write(buffer);
//                buffer = new byte[1024];
                os.write(b);
            }
            is.close();
            os.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private static class FileCopy
    {
        public interface OnFileCopyListener
        {
            void onCopying();
            
            void onFinished();
        }
        
        private static final ArrayList<OnFileCopyListener> mFileCopyListeners =
            new ArrayList<Assets1.FileCopy.OnFileCopyListener>(2);
        
        public void registerFileCopyListener(OnFileCopyListener listener)
        {
            mFileCopyListeners.add(listener);
        }
        
        public void unregisterFileCopyListener(OnFileCopyListener listener)
        {
            mFileCopyListeners.remove(listener);
        }
        
        public static void copy(String from, String to)
        {
        }
        
        private static void onCopying()
        {
            for (OnFileCopyListener l : mFileCopyListeners)
            {
                if (l != null)
                {
                    l.onCopying();
                }
            }
        }
        
        private static void onFinished()
        {
            for (OnFileCopyListener l : mFileCopyListeners)
            {
                if (l != null)
                {
                    l.onFinished();
                }
            }
        }
    }
}

package com.swordy.demo.android.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.swordy.demo.android.R;

public class GridView1 extends Activity
{
    private static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getPath();
    
    private static final String PATH_DCIM_CAMERA = PATH_SDCARD + "/DCIM/Camera";
    
    private static final String PATH_DCIM_THUMBNAIL = PATH_SDCARD + "/DCIM/.Thumbnail";
    
    private GridView mGridPhoto;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview1);
        
        mGridPhoto = (GridView)findViewById(R.id.gridview1_gridPhoto);
        
        ImageAdapter adapter = new ImageAdapter(this, getPaths());
        
        mGridPhoto.setAdapter(adapter);
    }
    
    private List<String> getPaths()
    {
        List<String> paths = new ArrayList<String>();
        
        ContentResolver cr = getContentResolver();
        Cursor c =
            cr.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
                new String[] {"_data, image_id"},
                null,
                null,
                null);
        
        c.moveToFirst();
        while (c.moveToNext())
        {
            String path = c.getString(0);
            paths.add(path);
        }
        
        return paths;
    }
    
    private class ImageAdapter extends BaseAdapter
    {
        
        private List<String> mPaths;
        
        private Context mContext;
        
        private ImageView[] mItemViews;
        
        private int mMaxViewCount = 45;
        
        private static final int MSG_UPDATE_IMAGEVIEW = 0;
        
        public ImageAdapter(Context context, List<String> paths)
        {
            mContext = context;
            mPaths = paths;
            mItemViews = new ImageView[mMaxViewCount];
        }
        
        @Override
        public int getCount()
        {
            return mPaths.size();
        }
        
        @Override
        public Object getItem(int position)
        {
            return position;
        }
        
        @Override
        public long getItemId(int position)
        {
            return position;
        }
        
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            Log.i("ImageView1", "position: " + position + "  convertView " + convertView);
            
            ImageView imageview = null;
            
            String path = mPaths.get(position);
            if (path == null)
                return null;
            
            if (convertView == null)
            {
                imageview = new ImageView(mContext);
                imageview.setLayoutParams(new LayoutParams(140, 140));
                imageview.setScaleType(ScaleType.CENTER_CROP);
            }
            else
            {
                imageview = (ImageView)convertView;
            }
            
            Bitmap bmp = BitmapFactory.decodeFile(path);
            imageview.setImageBitmap(bmp);
            
            return imageview;
        }
        
    }
    
}

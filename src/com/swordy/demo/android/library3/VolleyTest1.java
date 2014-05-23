package com.swordy.demo.android.library3;

import java.util.HashMap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class VolleyTest1 extends Activity {
	
	private MyImageCache mMyImageCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}
	
	private void init(){
		mMyImageCache = new MyImageCache();
		RequestQueue queue = Volley.newRequestQueue(this);
		ImageLoader loader = new ImageLoader(queue, mMyImageCache);
		NetworkImageView img = new NetworkImageView(this);
		setContentView(img);
		img.setImageUrl("http://img3.cache.netease.com/photo/0003/2014-05-23/9SU0NRJ400AJ0003.jpg", loader);
	}
	
	private class MyImageCache implements ImageCache{
		
		HashMap<String, Bitmap> cache = new HashMap<String, Bitmap>();

		@Override
		public Bitmap getBitmap(String arg0) {
			// TODO Auto-generated method stub
			return cache.get(arg0);
		}

		@Override
		public void putBitmap(String arg0, Bitmap arg1) {
			// TODO Auto-generated method stub
			cache.put(arg0, arg1);
		}
		
	}

}

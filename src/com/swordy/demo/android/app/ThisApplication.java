package com.swordy.demo.android.app;

import android.app.Application;

public class ThisApplication extends Application{
	private static final String TAG = ThisApplication.class.getSimpleName();

	private static ThisApplication mInstance;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		mInstance = this;
	}
	
	public static ThisApplication getInstance(){
		return mInstance;
	}
}

package com.swordy.demo.android.app;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.swordy.demo.android.R;

public class Service1 extends Activity {
	private static final String TAG = Service1.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service1);
		
		Button button1 = (Button)findViewById(R.id.button1);
		Button button2 = (Button)findViewById(R.id.button2);
		
		final Intent service1 = new Intent(this, MyService1.class);
		final Intent service2 = new Intent(this, MyService1.class);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if ("start service".equals(((Button) v).getText())) {
					startService(service1);
//					((Button) v).setText("stop service");
				} else {
					stopService(service1);
					((Button) v).setText("start service");
				}
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if ("start service".equals(((Button) v).getText())) {
					startService(service2);
					((Button) v).setText("stop service");
				} else {
					stopService(service2);
					((Button) v).setText("start service");
				}
			}
		});
	}
	
	public static class MyService1 extends Service {
		private static final String TAG = MyService1.class.getSimpleName();

		public static final String ACTION = "com.swordy.demo.android.app.MyService1";

		private Toast mToast;

		private int mServiceId = -1;

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}

		@Override
		public void onCreate() {
			super.onCreate();
			mToast = Toast.makeText(getApplicationContext(), "service created", Toast.LENGTH_LONG);
			mToast.show();
			Log.v(TAG, "service id: " + mServiceId + " created");
		}

		@Override
		public void onStart(Intent intent, int startId) {
			mServiceId = startId;
			super.onStart(intent, startId);
			mToast.setText("service id: " + mServiceId + "  started  ");
			mToast.show();
			Log.v(TAG, "service id: " + mServiceId + "  started  " + this);
		}

		@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
			mServiceId = startId;
			mToast.setText("service id: " + mServiceId + " flags: " + flags + "  started");
			mToast.show();
			Log.v(TAG, "service id: " + mServiceId + " flags: " + flags + "  started");
			return super.onStartCommand(intent, flags, startId);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
			mToast.setText("service id: " + mServiceId + " onDestroy");
			mToast.show();
			Log.v(TAG, "service id: " + mServiceId + " onDestroy  " + this);
		}

		@Override
		public void onTrimMemory(int level) {
			super.onTrimMemory(level);
			mToast.setText("service id: " + mServiceId + " onTrimMemory, level: " + level);
			mToast.show();
			Log.v(TAG, "service id: " + mServiceId + " onTrimMemory, level: " + level);
		}

		@Override
		public boolean onUnbind(Intent intent) {
			mToast.setText("service id: " + mServiceId + " onUnbind");
			mToast.show();
			Log.v(TAG, "service id: " + mServiceId + " onUnbind");
			return super.onUnbind(intent);
		}

		@Override
		public void onRebind(Intent intent) {
			super.onRebind(intent);
			mToast.setText("service id: " + mServiceId + " onRebind");
			mToast.show();
			Log.v(TAG, "service id: " + mServiceId + " onRebind");
		}

		@Override
		public void onTaskRemoved(Intent rootIntent) {
			super.onTaskRemoved(rootIntent);
			mToast.setText("service id: " + mServiceId + " onTaskRemoved");
			mToast.show();
			Log.v(TAG, "service id: " + mServiceId + " onTaskRemoved");
		}
	}
}

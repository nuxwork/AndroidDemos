package com.swordy.demo.android.view;

import android.app.Activity;
import android.os.Bundle;

import com.swordy.demo.android.R;

public class TextView1 extends Activity{
	
	private static final String TAG = TextView1.class.getSimpleName();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textview1);
	}

}

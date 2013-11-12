package com.swordy.demo.android.library.widget;

import android.app.Activity;
import android.os.Bundle;

import com.swordy.demo.android.R;
import com.swordy.library.android.widget.SeekBar;

public class SeekBar1 extends Activity{

	private static final String TAG = SeekBar1.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.library_seekbar1);
		
		SeekBar skb = (SeekBar)findViewById(R.id.seekBar1);
		
	}
	
}

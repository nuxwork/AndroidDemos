package com.swordy.demo.android.library.widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.swordy.demo.android.R;
import com.swordy.library.android.widget.SeekBarExt;

public class SeekBarExt1 extends Activity {
	private static final String TAG = SeekBarExt1.class.getSimpleName();

	private SeekBarExt mSkbHorizontal;
	private SeekBarExt mSkbVertical;
	private Toast mToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.library_seekbarext);

		mSkbHorizontal = (SeekBarExt) findViewById(R.id.seekBar1);
		mSkbVertical = (SeekBarExt) findViewById(R.id.seekBar2);

		mToast = Toast.makeText(getApplicationContext(), "", 1);

		OnSeekBarChangeListener listener = new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				mToast.setText("" + seekBar.getProgress());
				mToast.show();

			}
		};

		mSkbHorizontal.setOnSeekBarChangeListener(listener);
		mSkbVertical.setOnSeekBarChangeListener(listener);

	}
}

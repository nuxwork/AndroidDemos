package com.swordy.demo.android.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;

import com.swordy.demo.android.R;

public class Animation2 extends Activity {
	private static final String TAG = Animation2.class.getSimpleName();
	private ImageView mImgGirl;
	private Spinner mSpinner;
	private int mPosition;
	private boolean mFillBefore;
	private boolean mFillAfter;
	private boolean mFillEnable;

	private String[] mAnimNmaes = { "alpha", "rotate", "scale", "translate" };
	private int[] mAnimIds = { R.anim.animation1_alpha, R.anim.animation1_rotate,
			R.anim.animation1_scale, R.anim.animation1_translate };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.animation2);
		mImgGirl = (ImageView) findViewById(R.id.imageView1);
		mSpinner = (Spinner) findViewById(R.id.spinner1);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, mAnimNmaes);
		mSpinner.setAdapter(adapter);

		/* spinner can not set a OnItemClickedListener */

		// mSpinner.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view, int
		// position, long id) {
		// mPosition = position;
		// }
		//
		// });

		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				mPosition = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				mPosition = 0;
			}
		});

	}

	private Animation getAnimation() {
		Animation a = AnimationUtils.loadAnimation(this, mAnimIds[mPosition]);
		a.setFillAfter(mFillAfter);
		a.setFillBefore(mFillBefore);
		a.setFillEnabled(mFillEnable);
		return a;
	}

	public void onButtonClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			mImgGirl.startAnimation(getAnimation());
			break;
		case R.id.checkBox1:
			mFillAfter = ((CheckBox) v).isChecked();
			break;
		case R.id.checkBox2:
			mFillBefore = ((CheckBox) v).isChecked();
			break;
		case R.id.checkBox3:
			mFillEnable = ((CheckBox) v).isChecked();
			break;
		}
	}
}

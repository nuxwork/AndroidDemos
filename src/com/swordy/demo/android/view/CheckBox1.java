package com.swordy.demo.android.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

import com.swordy.demo.android.R;
import com.swordy.demo.android.app.ThisApplication;

public class CheckBox1 extends Activity {
	private static final String TAG = CheckBox1.class.getSimpleName();

	private Toast mToast = Toast.makeText(ThisApplication.getInstance(), "", Toast.LENGTH_SHORT);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkbox1);

		final CheckBox chb1 = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox chb2 = (CheckBox) findViewById(R.id.checkBox2);
		final CheckBox chb3 = (CheckBox) findViewById(R.id.checkBox3);
		final CheckBox chb4 = (CheckBox) findViewById(R.id.checkBox4);

		CompoundButton.OnCheckedChangeListener l = new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				String text = ((CheckBox) buttonView).getText().toString();
				mToast.setText(text + " checked state is " + isChecked);
				mToast.show();
			}
		};

		chb1.setOnCheckedChangeListener(l);
		chb2.setOnCheckedChangeListener(l);
		chb3.setOnCheckedChangeListener(l);

		chb4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				chb1.setChecked(isChecked);
				chb2.setChecked(isChecked);
				chb3.setChecked(isChecked);

				if (isChecked) {
					mToast.setText(" select all ");
				} else {
					mToast.setText(" unselect all ");
				}
				mToast.show();
			}
		});
	}

}

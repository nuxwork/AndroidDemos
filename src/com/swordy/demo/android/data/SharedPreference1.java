package com.swordy.demo.android.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.swordy.demo.android.R;

public class SharedPreference1 extends Activity {
	private static final String TAG = SharedPreference1.class.getSimpleName();

	private static final String PREFER_NAME = "SharedPreference1";
	private static final String KEY_NAME = "key";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_preference1);
		
		TextView txt = (TextView) findViewById(R.id.editText1);
		SharedPreferences prefer = getSharedPreferences(PREFER_NAME, Context.MODE_WORLD_READABLE);
		String str = prefer.getString(KEY_NAME, "");
		txt.setText(str);

	}

	public void onButtonClicked(View v) {
		TextView txt = (TextView) findViewById(R.id.editText1);
		SharedPreferences prefer = getSharedPreferences(PREFER_NAME, Context.MODE_WORLD_WRITEABLE);
		Editor editor = prefer.edit();
		editor.putString(KEY_NAME, txt.getText().toString());
		editor.commit();
		
		Toast.makeText(this, "save successed", Toast.LENGTH_LONG).show();
	}
}

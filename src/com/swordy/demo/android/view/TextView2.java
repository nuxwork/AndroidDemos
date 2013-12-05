package com.swordy.demo.android.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.swordy.demo.android.R;

public class TextView2 extends Activity {

	private static final String TAG = TextView2.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textview2);

		TextView txv1 = (TextView) findViewById(R.id.textView1);
		txv1.setText(Html.fromHtml("<u>使用html实现下划线样式</u>"));
	}

}

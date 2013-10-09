package com.swordy.demo.android.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.swordy.demo.android.R;

public class Text2 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text2);
		
		TextView txv1 = (TextView)findViewById(R.id.text2_txv1);
		txv1.setText(Html.fromHtml("<u>使用html实现下划线样式</u>"));
	}

}

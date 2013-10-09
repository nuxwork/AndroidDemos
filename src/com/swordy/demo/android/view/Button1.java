package com.swordy.demo.android.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.swordy.demo.android.R;
import com.swordy.library.android.widget.Alert;

public class Button1 extends Activity {
	private Toast mToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.button1);
	}
	
	public void onButtonClicked(View v){
		if(mToast == null){
			mToast = Toast.makeText(this, ((Button)v).getText().toString(), Alert.LENGTH_SHORT);
		}else{
			mToast.setText(((Button)v).getText().toString());
		}
		
		mToast.show();
	}

}

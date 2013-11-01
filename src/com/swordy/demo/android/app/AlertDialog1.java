package com.swordy.demo.android.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;

import com.swordy.demo.android.R;

public class AlertDialog1 extends Activity {
	private static final String TAG = AlertDialog1.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertdialog1);
	}

	public void onButtonClicked(View v) {
		AlertDialog dialog = new AlertDialog.Builder(this).setTitle("dialog title")
				.setIcon(R.drawable.ic_launcher).setMessage("dialog message")
				.setNegativeButton("cancle", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				}).setPositiveButton("ok", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				}).create();
		
		dialog.show();
	}

}

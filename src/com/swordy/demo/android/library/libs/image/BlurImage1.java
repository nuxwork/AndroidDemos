package com.swordy.demo.android.library.libs.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.swordy.demo.android.R;
import com.swordy.library.android.libs.image.BlurImage;

public class BlurImage1 extends Activity {

	private SeekBar mSeekBar;
	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.library_libs_image_blurimage1);

		mImageView = (ImageView) findViewById(R.id.imageView1);
		mImageView.setImageResource(R.drawable.bicycle);

		mSeekBar = (SeekBar) findViewById(R.id.seekBar1);
		mSeekBar.setMax(10);
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

				int p = seekBar.getProgress();

				if (p == 0) {
					mImageView.setImageResource(R.drawable.bicycle);
				} else {
					long time1 = System.currentTimeMillis();

					Bitmap bitmapIn = BitmapFactory.decodeResource(
							getResources(), R.drawable.bicycle);
					Bitmap bitmapOut = Bitmap.createBitmap(bitmapIn.getWidth(),
							bitmapIn.getHeight(), Config.ARGB_8888);
					BlurImage.generate(bitmapIn, bitmapOut, p);

					long time2 = System.currentTimeMillis();
					mImageView.setImageBitmap(bitmapOut);
					long time3 = System.currentTimeMillis();

					Toast.makeText(
							getBaseContext(),
							"高斯模糊耗时：" + (time2 - time1) + "  \n设置图片耗时："
									+ (time3 - time2) + "，\n总耗时："
									+ (time3 - time1), Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

			}
		});

	}

}

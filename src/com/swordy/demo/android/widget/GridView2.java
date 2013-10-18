package com.swordy.demo.android.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.swordy.demo.android.R;
import com.swordy.demo.android.app.ThisApplication;

public class GridView2 extends Activity {
	private static final String TAG = "GridView2";

	private GridView mGridPhoto;
	private Toast mToast = Toast.makeText(ThisApplication.getInstance(), "", Toast.LENGTH_LONG);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview1);

		mGridPhoto = (GridView) findViewById(R.id.gridview1_gridPhoto);

		ImageAdapter adapter = new ImageAdapter(this, getPaths());

		mGridPhoto.setAdapter(adapter);
		// mGridPhoto.setOnScrollListener(new OnScrollListener() {
		//
		// @Override
		// public void onScrollStateChanged(AbsListView view, int scrollState) {
		//
		// }
		//
		// @Override
		// public void onScroll(AbsListView view, int firstVisibleItem, int
		// visibleItemCount,
		// int totalItemCount) {
		// String info = "total: " + totalItemCount + " first: " +
		// firstVisibleItem
		// + " visible: " + visibleItemCount + " last: "
		// + (firstVisibleItem + visibleItemCount);
		// Log.v(TAG, info);
		// mToast.setText(info);
		// mToast.show();
		// }
		// });

	}

	private List<String> getPaths() {
		List<String> paths = new ArrayList<String>();

		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
				new String[] { "_data, image_id" }, null, null, null);

		Log.v(TAG, "photos count: " + c.getCount());

		c.moveToFirst();
		while (c.moveToNext()) {
			String path = c.getString(0);
			paths.add(path);
		}

		return paths;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	private class ImageAdapter extends BaseAdapter {

		private List<String> mPaths;

		private Context mContext;

		private LayoutInflater mInflater;

		private int mCacheSize = 80;

		private Bitmap[] mBitmaps;

		public ImageAdapter(Context context, List<String> paths) {
			mContext = context;
			mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mPaths = paths;

			mBitmaps = new Bitmap[mCacheSize];
			new Thread(new ImageLoader()).start();
		}

		@Override
		public int getCount() {
			return mPaths.size();
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.gridview2_grid_item, null);
				holder.preview = (ImageView) convertView
						.findViewById(R.id.gridview2_grid_item_imgPreview);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Bitmap bitmap = mBitmaps[position % mCacheSize];
			// if(bitmap == null)
			// notifyDataSetChanged();
			holder.previewData = bitmap;
			holder.preview.setImageBitmap(holder.previewData);
			return convertView;
		}

		private class ViewHolder {
			public ImageView preview;
			public Bitmap previewData;
		}

		private class ImageLoader implements Runnable {

			@Override
			public void run() {
				for (int i = 0; i != mCacheSize; i++) {
					mBitmaps[i] = BitmapFactory.decodeFile(mPaths.get(i));
					if (i % 3 == 0)
						mHandler.sendEmptyMessage(0);
				}
			}
		};

		private Handler mHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				notifyDataSetChanged();
			}

		};
	}

}

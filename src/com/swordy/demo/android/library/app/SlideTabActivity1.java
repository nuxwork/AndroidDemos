package com.swordy.demo.android.library.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.swordy.demo.android.R;
import com.swordy.library.android.app.SlideTabActivity;

public class SlideTabActivity1 extends SlideTabActivity {

	private static final String[] names = { "one", "two", "three", "four" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.library_slidetabactivity1);

		setTabAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, names));

		setPagerAdapter(mPagerAdapter);

//		 ArrayList<HashMap<String, String>> data = new
//		 ArrayList<HashMap<String, String>>(
//		 names.length);
//		 for(int i=0; i != names.length; i++)
//		 {
//			 HashMap<String, String> item = new HashMap<String, String>();
//			 item.put("color", "null");
//			 data.add(item);
//		 }
//		
//		 setIndicatorAdapter(new SimpleAdapter(this, data,
//		 R.layout.library_slidetabactivity1_indicator,
//		 new String[] { "color" }, new int[] { R.id.view }));

		getIndicator().setItemLayout(
				R.layout.library_slidetabactivity1_indicator,
				new LayoutParams(30, 30));
		getIndicator().add(names.length);
	}

	private PagerAdapter mPagerAdapter = new FragmentPagerAdapter(
			getSupportFragmentManager()) {

		@Override
		public int getCount() {
			return names.length;
		}

		@Override
		public Fragment getItem(int position) {
			return MyFragment.create(names[position]);
		}
	};

	@SuppressLint("ValidFragment")
	private static class MyFragment extends Fragment {

		public static MyFragment create(String name) {
			MyFragment f = new MyFragment();
			Bundle b = new Bundle();
			b.putString("name", name);
			f.setArguments(b);
			return f;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// return super.onCreateView(inflater, container,
			// savedInstanceState);
			TextView txv = new TextView(getActivity());
			Random r = new Random(System.currentTimeMillis());

			txv.setBackgroundColor(r.nextInt() >> 8 | 0xFF << 24);
			txv.setText(getArguments().getString("name"));
			return txv;
		}
	}
}

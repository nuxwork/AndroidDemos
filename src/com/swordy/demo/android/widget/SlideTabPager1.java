package com.swordy.demo.android.widget;

import java.util.Random;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.swordy.demo.android.R;
import com.swordy.library.android.widget.SlideTabPager;

public class SlideTabPager1 extends FragmentActivity {
	private SlideTabPager mSlideTabPager;
	final String[] addresses = { "Apple", "Microsoft", "Google", "IBM", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.widget_slidetabpager1);

		mSlideTabPager = (SlideTabPager) findViewById(R.id.slideTabPager1);


		Adapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, addresses);

		mSlideTabPager.setTabAdapter(adapter);

		mSlideTabPager.setPagerAdapter(new MyPagerAdapter(getSupportFragmentManager()));
	}

	private class MyPagerAdapter extends FragmentStatePagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return MyFragment.create(addresses[position]);
		}

		@Override
		public int getCount() {
			return addresses.length;
		}

	}

	public static class MyFragment extends Fragment {
		public static MyFragment create(String address) {
			MyFragment f = new MyFragment();
			Bundle b = new Bundle();
			b.putString("address", address);
			f.setArguments(b);
			return f;
		}

		@SuppressLint("NewApi")
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Random r = new Random(System.currentTimeMillis());

			Bundle b = getArguments();

//			View v = inflater.inflate(R.layout.fragment_viewpager1_layout1,
//					null);
//			v.setBackgroundColor(r.nextInt() >> 8 | 0xFF << 24);
//
//			TextView txvAddress = (TextView) v.findViewById(R.id.textView1);
//			txvAddress.setTextColor(r.nextInt() >> 8 | 0xFF << 24);
//			txvAddress.setBackgroundColor(r.nextInt() >> 8 | 0xFF << 24);
//
//			txvAddress.setText(b.getString("address", ""));
			View v = new View(getActivity());
			v.setBackgroundColor(r.nextInt() >> 8 | 0xFF << 24);
			return v;
		}

	}
}

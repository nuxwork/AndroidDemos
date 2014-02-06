package com.swordy.demo.android.fragment;

import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swordy.demo.android.R;

/**
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class ViewPager1 extends FragmentActivity
{
	private static final String TAG = "AndroidDemos.ViewPager1";

	private ViewPager mViewPager;

	private PagerAdapter mPagerAdapter;

	private String[] addresses = { "first", "second", "third" };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_viewpager1);

		mViewPager = (ViewPager) findViewById(R.id.viewPager1);
		mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);
	}

	private class MyPagerAdapter extends FragmentStatePagerAdapter
	{

		public MyPagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int position)
		{
			return MyFragment.create(addresses[position]);
		}

		@Override
		public int getCount()
		{
			return addresses.length;
		}

	}

	public static class MyFragment extends Fragment
	{
		public static MyFragment create(String address)
		{
			MyFragment f = new MyFragment();
			Bundle b = new Bundle();
			b.putString("address", address);
			f.setArguments(b);
			return f;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			Random r = new Random(System.currentTimeMillis());
			int color = r.nextInt();

			Bundle b = getArguments();

			View v = inflater.inflate(R.layout.fragment_viewpager1_layout1, null);
			v.setBackgroundColor(color);

			TextView txvAddress = (TextView) v.findViewById(R.id.textView1);
			txvAddress.setTextColor(color + 0x00440044);
			txvAddress.setBackgroundColor(color + 0x00444400);

			txvAddress.setText(b.getString("address", ""));
			return v;
		}

	}
}

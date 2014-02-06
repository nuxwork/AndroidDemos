package com.swordy.demo.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swordy.demo.android.R;
import com.swordy.library.android.util.ELog;

/**
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class TabHost1 extends FragmentActivity
{
	private static final String TAG = "AndroidDemos.TabHost1";

	private FragmentTabHost mTabHost;

	private String[] tabnames = { "One", "Two", "Three" };

	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		setContentView(R.layout.fragment_tabhost1);

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

		buildTab(mTabHost, tabnames[0], MyFragment.class);
		buildTab(mTabHost, tabnames[1], MyFragment.class);
		buildTab(mTabHost, tabnames[2], MyFragment.class);
	}

	private void buildTab(FragmentTabHost tabHost, String tag, Class<?> cls)
	{
		Bundle b = new Bundle();
		b.putString("tag", tag);
		tabHost.addTab(tabHost.newTabSpec(tag).setIndicator(tag), cls, b);
	}

	public static class MyFragment extends Fragment
	{

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			ELog.i(TAG, "@--> onCreateView");
			return super.onCreateView(inflater, container, savedInstanceState);
		}

	}
}

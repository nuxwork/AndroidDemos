package com.swordy.demo.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swordy.demo.android.R;

/**
 * 1. 如果要使用Fragment，那么它的Activity必须是FragmentActivity的
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class Fragment1 extends FragmentActivity
{
	private static final String TAG = "AndroidDemos.Fragment1";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_fragment1);
	}

	public static class MyFragment extends Fragment
	{

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			View v = inflater.inflate(R.layout.fragment_fragment1_layout1, null);
			return v;
		}

	}

}

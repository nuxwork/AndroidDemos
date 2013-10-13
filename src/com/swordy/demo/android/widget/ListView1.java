package com.swordy.demo.android.widget;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListView1 extends ListActivity {

	private Toast mToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final ListView listview = getListView();
		
		TextView header = new TextView(this);
		header.setText("this is header, enable divider");
		header.setBackgroundColor(0xff0000ff);
		listview.addHeaderView(header);
		listview.setHeaderDividersEnabled(true);

		TextView footer = new TextView(this);
		footer.setText("this is footer, disable divider");
		footer.setBackgroundColor(0xff00ff00);
		listview.addFooterView(footer);

		listview.setDividerHeight(5);

		final String[] items = { "Apple", "Microsoft", "Google", "IBM", "Oracle", "Facebook",
				"Youtube", "Github", "Android", "Ubuntu", "Windows", "MacOS X", "Arch" };

		// setAdater() must called after set footer or header
		Adapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				android.R.id.text1, items);

		listview.setAdapter((ListAdapter) adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				position -= listview.getHeaderViewsCount();
				
				if(position < 0 || position >= items.length)
					return;
				
				String text = items[position] + " , position:" + position + " , id:" + id;
				if (mToast == null) {
					mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
				} else {
					mToast.setText(text);
				}
				mToast.show();
			}

		});
	}

}

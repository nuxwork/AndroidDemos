package com.swordy.demo.android.device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.swordy.demo.android.R;

public class Wifilist1 extends Activity
{
    private static final String TAG = "AndroidDemos.Wifilist1";
    
    private ListView mListView;
    
    private SimpleAdapter mAdapter;
    
    private WifiManager mWifiManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        initView(R.layout.device_wifilist1);
        
        mWifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
    }
    
    private void initView(int layoutResID)
    {
        setContentView(layoutResID);
        
        mListView = (ListView)findViewById(R.id.listView1);
    }
    
    public void onViewClick(View v)
    {
        scan();
    }
    
    private void scan()
    {
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        
        final List<ScanResult> results = mWifiManager.getScanResults();
        if (results == null)
        {
            mListView.setAdapter(null);
            return;
        }
        
        for (ScanResult sr : results)
        {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("SSID", sr.SSID);
            item.put("BSSID", sr.BSSID);
            item.put("capabilities", sr.capabilities);
            item.put("frequency", "" + sr.frequency);
            item.put("level", "" + sr.level);
            /*item.put("timestamp", ""+sr.timestamp);*/
            
            data.add(item);
        }
        
        mAdapter =
            new SimpleAdapter(this, data, R.layout.device_wifilist1_item, new String[] {"SSID", "BSSID",
                "capabilities", "frequency", "level"}, new int[] {R.id.SSID, R.id.BSSID, R.id.capabilities,
                R.id.frequency, R.id.level});
        
        mListView.setAdapter(mAdapter);
        
        mListView.setOnItemSelectedListener(new OnItemSelectedListener()
        {
            
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ScanResult sr = results.get(position);
                connect(sr);
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                
            }
        });
    }
    
    private void connect(ScanResult sr)
    {
        View v = LayoutInflater.from(this).inflate(R.layout.device_wifilist1_connect, null);
        final EditText edtPasswd = (EditText)v.findViewById(R.id.editText1);
        
        new AlertDialog.Builder(this).setTitle(sr.SSID)
            .setIcon(R.drawable.wifi)
            .setView(v)
            .setNegativeButton("cancle", null)
            .setPositiveButton("Connect", new OnClickListener()
            {
                
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    String passwd = edtPasswd.getText().toString();
                }
            })
            .create()
            .show();
    }
}

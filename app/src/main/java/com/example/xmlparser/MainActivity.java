package com.example.xmlparser;

import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import com.example.xmlparser.model.Employee;
import com.example.xmlparser.model.MenuItem;
import com.example.xmlparser.parser.XMLPullParserHandler;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lv_list;
	List<MenuItem> arrMenuItem = null;
	FrameLayout fl_container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		arrMenuItem = XMLPullParserHandler.parseXML(getResources().getXml(R.xml.slideitem));
		ArrayAdapter adapter = new ArrayAdapter<MenuItem>(
				getApplicationContext(), R.layout.list_item, arrMenuItem);
		lv_list.setAdapter(adapter);
		initListener();
	}

	private void initView() {
		lv_list = (ListView) findViewById(R.id.lv_slidemenu);
		fl_container = (FrameLayout) findViewById(R.id.fl_container);
	}
	private void initListener() {
		lv_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
					FragmentManager fm = getFragmentManager();
					try {
						Fragment obj = (Fragment)arrMenuItem.get(position).getClassName().newInstance();
						fm.beginTransaction().replace(R.id.fl_container, obj).commit();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
	}

}

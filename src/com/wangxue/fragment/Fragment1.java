package com.wangxue.fragment;

import java.util.List;

import com.example.sbingmenuxml.R;
import com.wangxue.adapter.MyAdapter;
import com.wangxue.bean.User;
import com.wangxue.util.GetXml;

import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragment1 extends Fragment {

	GetXml gx;
	ListView listview;
	List<User> list;
	MyAdapter adapter;
	String path = "http://169.254.55.111:8080/project/xml/data10.xml";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab1, null);
		listview = (ListView) view.findViewById(R.id.listview);
		gx = new GetXml();
		list = gx.getlist(path);
		adapter = new MyAdapter(list, getActivity());
		listview.setAdapter(adapter);
		return view ;
	}

	
}

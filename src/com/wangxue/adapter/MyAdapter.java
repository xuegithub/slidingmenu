package com.wangxue.adapter;

import java.util.List;

import com.example.sbingmenuxml.R;
import com.wangxue.bean.User;
import com.wangxue.util.Downpic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	List<User> list;
	Context context;
	
	
	public MyAdapter(List<User> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh;
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item2,null);
			vh = new ViewHolder();
			vh.image = (ImageView) convertView.findViewById(R.id.image);
			vh.tv1 = (TextView) convertView.findViewById(R.id.name);
			vh.tv2 = (TextView) convertView.findViewById(R.id.catetitle);
			vh.tv3 = (TextView) convertView.findViewById(R.id.catecontent);
			vh.tv4 = (TextView) convertView.findViewById(R.id.cateprice);
			convertView.setTag(vh);
		}else{
			vh = (ViewHolder) convertView.getTag();
		}
		User user = list.get(position);
		vh.tv1.setText(user.getName());
		vh.tv2.setText(user.getCatetitle());
		vh.tv3.setText(user.getCatecontent());
		vh.tv4.setText(user.getCateprice());
		new Downpic().down("http://169.254.55.111:8080"+user.getCateurl(), vh.image);
		return convertView;
	}

	class ViewHolder{
		ImageView image;
		TextView tv1,tv2,tv3,tv4;
	}
}

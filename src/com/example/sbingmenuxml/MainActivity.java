package com.example.sbingmenuxml;

import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import com.wangxue.fragment.Fragment1;
import com.wangxue.fragment.Fragment2;
import com.wangxue.fragment.Fragment3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends SlidingFragmentActivity {

	TextView tv1,tv2,tv3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		slidingmenu();
		find();
		getSupportFragmentManager().beginTransaction().replace(R.id.frame, new Fragment1()).commit();
	}
	
	private void slidingmenu(){
		setContentView(R.layout.activity_main);
		SlidingMenu menu = getSlidingMenu();
		setBehindContentView(R.layout.item);
		menu.setSecondaryMenu(R.layout.item);;
		menu.setTouchModeAbove(menu.TOUCHMODE_FULLSCREEN);
		menu.setBehindOffset(200);
		menu.setMode(menu.LEFT);
	}
	
	private void find(){
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv1.setOnClickListener(view);
		tv2.setOnClickListener(view);
		tv3.setOnClickListener(view);
	}
	
	View.OnClickListener view = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tv1:
				getSupportFragmentManager().beginTransaction().replace(R.id.frame, new Fragment1()).commit();
				break;

			case R.id.tv2:
				getSupportFragmentManager().beginTransaction().replace(R.id.frame, new Fragment2()).commit();
				break;
			case R.id.tv3:
				getSupportFragmentManager().beginTransaction().replace(R.id.frame, new Fragment3()).commit();
				break;
			}
		}
	};
}

package com.wangxue.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class Downpic {

	public void down(final String path,final ImageView iv){
		final Handler handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				if(msg.what == 200){
					Bitmap bm = (Bitmap) msg.obj;
					iv.setImageBitmap(bm);
				}
			}
		};
		new Thread(){
			public void run() {
				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					int code = conn.getResponseCode();
					if(code == 200){
						System.out.println("«Î«ÛÕº∆¨≥…π¶");
						InputStream in = conn.getInputStream();
						Bitmap bitmap = BitmapFactory.decodeStream(in);
						Message msg = handler.obtainMessage();
						msg.obj = bitmap;
						msg.what = 200;
						handler.sendMessage(msg);
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
}

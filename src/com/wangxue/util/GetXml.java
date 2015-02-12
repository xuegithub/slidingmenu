package com.wangxue.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.R.integer;
import android.util.Xml;

import com.wangxue.bean.User;

public class GetXml {

	User user = null;
	String mname = "";
	List<User> list = null;
	HttpClient client;
	public List<User> getlist(String path){
		client = new DefaultHttpClient();
		HttpPost post = new HttpPost(path);
		try {
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode() == 200){
				InputStream in = response.getEntity().getContent();
				XmlPullParser parser = Xml.newPullParser();
				try {
					parser.setInput(new InputStreamReader(in));
					int type = parser.getEventType();
					while(type != XmlPullParser.END_DOCUMENT){
						String name = parser.getName();
						switch (type) {
						case XmlPullParser.START_TAG:
							if("hotels".equals(name)){
								list = new ArrayList<User>();
							}else if("hotel".equals(name)){
								mname = parser.getAttributeValue(0);
							}else if("cate".equals(name)){
								user = new User();
								user.setName(mname);
							}else if("cateurl".equals(name)){
								user.setCateurl(parser.nextText());
							}else if("catetitle".equals(name)){
								user.setCatetitle(parser.nextText());
							}
							else if("catecontent".equals(name)){
								user.setCatecontent(parser.nextText());
							}
							else if("cateprice".equals(name)){
								user.setCateprice(parser.nextText());
							}
							break;
						case XmlPullParser.END_TAG:
							if("cate".equals(name)){
								list.add(user);
							}
							break;
						case XmlPullParser.TEXT:
							break;
						}
						type = parser.next();
					}
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}

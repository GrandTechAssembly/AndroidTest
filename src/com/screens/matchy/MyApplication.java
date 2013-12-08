package com.screens.matchy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

	private static Context mContext;
	private static Activity act;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
	}

	public static Context getContext() {
		return mContext;
	}
	
	public static void setActivity(Activity act) {
		MyApplication.act = act;
	}
	
	public static Activity getActivity(){
		return act;
	}
}
package com.screens.matchy;

import com.main.matchy.R;

import android.app.Activity;
import android.os.Bundle;

public class SearchScreen extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_screen);
		MyApplication.setActivity(this);
		
		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
	}
}

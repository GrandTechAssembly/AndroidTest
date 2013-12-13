package com.screens.matchy;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;

import com.adapter.matchy.ScrollViews;
import com.main.matchy.R;

public class ProfileScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_screen);
		MyApplication.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createInnerScrolls();
	}
	
	private void createInnerScrolls(){
		ScrollViews scrollViews = new ScrollViews();

		TextView description = (TextView) findViewById(R.id.description);
		TextView profileInfo = (TextView) findViewById(R.id.profileInfo);
		ScrollView wrapperScrollView = (ScrollView) findViewById(R.id.wrapperScrollView);

		description.setMovementMethod(new ScrollingMovementMethod());
		profileInfo.setMovementMethod(new ScrollingMovementMethod());
		description.setOnTouchListener(scrollViews.onTouch());
		profileInfo.setOnTouchListener(scrollViews.onTouch());
		
		int[] viewArray = new int[] {R.id.description, R.id.profileInfo};
		wrapperScrollView.setOnTouchListener(scrollViews.onTouchWrapper(viewArray));
	}
}
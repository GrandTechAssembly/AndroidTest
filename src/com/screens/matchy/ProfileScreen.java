package com.screens.matchy;

import com.main.matchy.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;

public class ProfileScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_screen);
		MyApplication.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();

		TextView description = (TextView) findViewById(R.id.description);
		TextView profileInfo = (TextView) findViewById(R.id.profileInfo);
		ScrollView wrapperScrollView = (ScrollView) findViewById(R.id.wrapperScrollView);

		description.setMovementMethod(new ScrollingMovementMethod());
		profileInfo.setMovementMethod(new ScrollingMovementMethod());

		description.setOnTouchListener(onTouch());
		profileInfo.setOnTouchListener(onTouch());
		
		wrapperScrollView.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				findViewById(R.id.description).getParent().requestDisallowInterceptTouchEvent(false);
				findViewById(R.id.profileInfo).getParent().requestDisallowInterceptTouchEvent(false);
				return false;
			}
		});
	}
	
	public OnTouchListener onTouch() {
		return new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				v.getParent().requestDisallowInterceptTouchEvent(true);
				return false;
			}
		};
	}
}
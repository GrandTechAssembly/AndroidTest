package com.screens.matchy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.main.matchy.R;

public class BuildNavigation {
	Context context;
	Activity activity;
	
	public void createIntents(){
		context = MyApplication.getContext();
		activity = MyApplication.getActivity();
		
		getButton(R.id.homeButton, MainScreen.class);
		getButton(R.id.profileButton, ProfileScreen.class);
		getButton(R.id.matchButton, MatchScreen.class);
		getButton(R.id.searchButton, SearchScreen.class);
		getButton(R.id.logoutButton, LoginActivity.class);
	}
	
	private Button getButton(int buttonId, Class<?> className) {
		Button result;
		
		result = (Button) activity.findViewById(buttonId);
		result.setOnClickListener(onClick(className));
		return result;
	}
	
	public OnClickListener onClick(final Class<?> className) {
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(activity.getClass()!=className){
					Intent intent = new Intent(context, className);
					activity.startActivity(intent);
				}
			}
		};
	}	
	
	
}

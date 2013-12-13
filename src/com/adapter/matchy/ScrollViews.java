package com.adapter.matchy;

import com.screens.matchy.MyApplication;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class ScrollViews {

	public OnTouchListener onTouch() {
		return new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				v.getParent().requestDisallowInterceptTouchEvent(true);
				return false;
			}
		};
	}

	public OnTouchListener onTouchWrapper(final int[] viewID) {
		return new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				for(int i=0;i<viewID.length;i++){
					MyApplication.getActivity().findViewById(viewID[i]).getParent().requestDisallowInterceptTouchEvent(false);
				}	
				return false;
			}
		};
	}
}

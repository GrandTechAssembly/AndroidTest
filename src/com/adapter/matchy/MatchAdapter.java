package com.adapter.matchy;

import java.util.ArrayList;

import com.main.matchy.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class MatchAdapter extends BaseAdapter{

	public ArrayList<Matches> matchList;
	private Activity activity;
	
	private int listItem;
	
	public MatchAdapter(Activity activity, ArrayList<Matches> matchData) {
		super();
		
		this.activity = activity;
		this.matchList = matchData;
		listItem = R.layout.match_item;
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return matchList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return matchList.get(position);
	}

	@Override
	public long getItemId(int position) {
		Matches curMatch = matchList.get(position);
		return 0;
	}

	private class ViewHolder {
		TextView title;
		TextView description;
		TextView matchDate;
		TextView matchPlace;
		TextView matchEducation;
		TextView matchWorkTime;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();
		Matches curMatch = matchList.get(position);

		convertView = null;
		
		convertView = inflater.inflate(listItem, null);
		
		holder = new ViewHolder();
		holder.title = (TextView) convertView.findViewById(R.id.matchTitle);
		holder.description = (TextView) convertView.findViewById(R.id.matchDescription);
		holder.matchDate = (TextView) convertView.findViewById(R.id.matchDate);
		holder.matchPlace = (TextView) convertView.findViewById(R.id.matchPlace);
		holder.matchEducation = (TextView) convertView.findViewById(R.id.matchEducation);
		holder.matchWorkTime = (TextView) convertView.findViewById(R.id.matchWorkTime);
		
		convertView.setTag(holder);
		
		holder.title.setText(curMatch.getCompany());
		holder.description.setText(curMatch.getDescription());
		holder.matchDate.setText(curMatch.getDate());
		holder.matchPlace.setText(curMatch.getPlace());
		holder.matchEducation.setText(curMatch.getEducation());
		holder.matchWorkTime.setText(curMatch.getWorkTime());

		return convertView;
	}

}

package com.screens.matchy;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ScrollView;

import com.adapter.matchy.MatchAdapter;
import com.adapter.matchy.Matches;
import com.adapter.matchy.ScrollViews;
import com.main.matchy.R;

public class MatchScreen extends Activity{
	private static ArrayList<Matches> newMatchList = new ArrayList<Matches>();
	private static ArrayList<Matches> oldMatchList = new ArrayList<Matches>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_screen);
		MyApplication.setActivity(this);
		
		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		fillMatchList();
		createInnerScrolls();
	}
	
	private void fillMatchList() {
		ListView newTempMatchList = (ListView) findViewById(R.id.newMatchesList);
		ListView oldTempMatchList = (ListView) findViewById(R.id.oldMatchesList);
        if (newMatchList.size() < 100) {
            for (int i = 0; i < 100; i++) {
                Matches match = new Matches();
                match.setMatchType("Nieuw" + i);
                match.setCompany("Company" + i);
                match.setDate("Date" + i);
                match.setPlace("Place" + i);
                match.setWorkTime("WorkTime" + i);
                match.setEducation("Education" + i);
                match.setDescription(" Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium." + i);
                newMatchList.add(match);
            }
        }
        if (oldMatchList.size() < 100) {
            for (int i = 0; i < 100; i++) {
                Matches match = new Matches();
                match.setMatchType("Old Nieuw" + i);
                match.setCompany("Old Company" + i);
                match.setDate("Old Date" + i);
                match.setPlace("Old Place" + i);
                match.setWorkTime("Old WorkTime" + i);
                match.setEducation("Old Education" + i);
                match.setDescription("Old Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium." + i);
                oldMatchList.add(match);
            }
        }
    	MatchAdapter newmatchAdapter = new MatchAdapter(MatchScreen.this, newMatchList);
        newTempMatchList.setAdapter(newmatchAdapter);
        MatchAdapter oldmatchAdapter = new MatchAdapter(MatchScreen.this, oldMatchList);
        oldTempMatchList.setAdapter(oldmatchAdapter);
	}

	private void createInnerScrolls(){
		ScrollViews scrollViews = new ScrollViews();

		ListView newMatchList = (ListView) findViewById(R.id.newMatchesList);
		ListView oldMatchList = (ListView) findViewById(R.id.oldMatchesList);
		ScrollView wrapperScrollView = (ScrollView) findViewById(R.id.wrapperScrollView);

		newMatchList.setOnTouchListener(scrollViews.onTouch());
		oldMatchList.setOnTouchListener(scrollViews.onTouch());
		
		int[] viewArray = new int[] {R.id.newMatchesList, R.id.oldMatchesList};
		wrapperScrollView.setOnTouchListener(scrollViews.onTouchWrapper(viewArray));
	}
}

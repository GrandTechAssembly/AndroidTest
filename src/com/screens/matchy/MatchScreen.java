package com.screens.matchy;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.adapter.matchy.MatchAdapter;
import com.adapter.matchy.Matches;
import com.main.matchy.R;

public class MatchScreen extends Activity{
	private ArrayList<Matches> matchList = new ArrayList<Matches>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_screen);
		MyApplication.setActivity(this);
		
		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		fillMatchList();
	}
	
	private void fillMatchList() {
		ListView newMatchList = (ListView) findViewById(R.id.newMatchesList);
        if (matchList.size() < 100) {
            for (int i = 0; i < 100; i++) {
                Matches match = new Matches();
                match.setMatchType("Nieuw" + i);
                match.setCompany("Company" + i);
                match.setDate("Date" + i);
                match.setPlace("Place" + i);
                match.setWorkTime("WorkTime" + i);
                match.setEducation("Education" + i);
                match.setDescription(" Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium." + i);
                matchList.add(match);
            }
            MatchAdapter matchAdapter = new MatchAdapter(MatchScreen.this, matchList);
            newMatchList.setAdapter(matchAdapter);
        }
	}
}

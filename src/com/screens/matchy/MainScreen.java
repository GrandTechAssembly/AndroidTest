package com.screens.matchy;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.adapter.matchy.MatchAdapter;
import com.adapter.matchy.Matches;
import com.adapter.matchy.ScrollViews;
import com.adapter.matchy.Spinners;
import com.main.matchy.R;

public class MainScreen extends Activity {
	private static ArrayList<Matches> matchList = new ArrayList<Matches>();
	private List<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		MyApplication.setActivity(this);
		
		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createInnerScrolls();
		fillMatchList();
		createSpinner();

		Button seeMatchesButton = (Button) findViewById(R.id.seeMatchesButton);
		Button advancedSearchButton = (Button) findViewById(R.id.searchAdvanced);
		seeMatchesButton.setOnClickListener(onClickIntent(MatchScreen.class));
		advancedSearchButton.setOnClickListener(onClickIntent(SearchScreen.class));
	}
	
	private OnClickListener onClickIntent(final Class<?> classIntent) {
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainScreen.this, classIntent);
				startActivity(intent);
			}
		};
	}

	private void fillMatchList() {
		ListView newMatchList = (ListView) findViewById(R.id.newMatches);
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
        }
        MatchAdapter matchAdapter = new MatchAdapter(MainScreen.this, matchList);
        newMatchList.setAdapter(matchAdapter);
	}
	
	private void createInnerScrolls(){
		ScrollViews scrollViews = new ScrollViews();

		ListView matchList = (ListView) findViewById(R.id.newMatches);
		ScrollView wrapperScrollView = (ScrollView) findViewById(R.id.wrapperScrollView);

		matchList.setOnTouchListener(scrollViews.onTouch());
		
		int[] viewArray = new int[] {R.id.newMatches};
		wrapperScrollView.setOnTouchListener(scrollViews.onTouchWrapper(viewArray));
	}
	
	private void createSpinner(){		
		list.add("PHP");
		list.add("Java");
		list.add("C#");
		list.add("ASP");
		list.add("Android");

		Spinner branchSpinner = (Spinner) findViewById(R.id.branchSpinner);
		ArrayAdapter<String> branchSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, list);
		branchSpinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		branchSpinner.setAdapter(branchSpinnerAdapter);
		Spinners.setFirstLoaded(true);
		branchSpinner.setOnItemSelectedListener(Spinners.onItemSelected(list, R.id.branchTextView));
	}
}
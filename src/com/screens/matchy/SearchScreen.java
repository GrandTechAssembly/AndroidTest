package com.screens.matchy;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.adapter.matchy.Spinners;
import com.main.matchy.R;

public class SearchScreen extends Activity {
	private List<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_screen);
		MyApplication.setActivity(this);
		
		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createSpinner();
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
		branchSpinner.setOnItemSelectedListener(Spinners.onItemSelected(list, R.id.branchTextView1));
	}
}

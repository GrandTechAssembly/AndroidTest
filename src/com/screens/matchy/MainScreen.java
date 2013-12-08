package com.screens.matchy;

import java.util.ArrayList;
import java.util.List;

import com.main.matchy.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		MyApplication.setActivity(this);
		
		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		final List<String> list = new ArrayList<String>();
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");
		list.add("Item 4");
		list.add("Item 5");

		Spinner sp1 = (Spinner) findViewById(R.id.branchSpinner);
		ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.spinner_item, list);
		adp.setDropDownViewResource(R.layout.spinner_item);
		sp1.setAdapter(adp);

		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), list.get(position), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
}
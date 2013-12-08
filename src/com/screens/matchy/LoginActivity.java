package com.screens.matchy;

import com.main.matchy.R;
import com.soaps.matchy.CallSoapLogin;
import com.soaps.matchy.Caller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	public static String result;
	//final  AlertDialog error = new AlertDialog.Builder(this).create();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		Button loginButton = (Button) findViewById(R.id.login);
		
		loginButton.setOnClickListener(onClick());
		
	}

	public OnClickListener onClick() {
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				CallSoapLogin callLogin = new CallSoapLogin();

				try {
					EditText ed1 = (EditText) findViewById(R.id.userNameInsert);
					EditText ed2 = (EditText) findViewById(R.id.passwordInsert);
					String email = ed1.getText().toString();
					String pass = ed2.getText().toString();
					result = "StartConnection";
					
					Caller caller = new Caller(); 
					caller.email = email;
	                caller.pass = pass; 
	                caller.join(); 
	                caller.start();
					
	                while(result=="StartConnection") {
	                    try {
	                        Thread.sleep(10); 
	                    } catch(Exception ex) {
	                    	System.out.println("Thread did not sleep!");
	                    }
	                }
	                if(result.equals("1")){
	    				Intent intent = new Intent(LoginActivity.this, MainScreen.class);
	    				startActivity(intent);
	                }
	                else {
	                	Toast.makeText(getApplicationContext(), "Foutieve inloggegevens ingevoerd, probeer opnieuw", 
	                			   Toast.LENGTH_LONG).show();
	                }
				} catch (Exception ex) {
		        	Toast.makeText(MyApplication.getContext(), "Fout met verbinden naar de server, probeer het later nog eens", 
		        			   Toast.LENGTH_LONG).show();
				}
			}
		};
	}
}

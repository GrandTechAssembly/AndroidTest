package com.screens.matchy;

import com.main.matchy.R;
import com.soaps.matchy.CallerLogin;
import com.soaps.matchy.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	public static Boolean result, startConn;

	// final AlertDialog error = new AlertDialog.Builder(this).create();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		MyApplication.setActivity(this);

		Button loginButton = (Button) findViewById(R.id.login);
		loginButton.setOnClickListener(onClick());
	}

	public OnClickListener onClick() {
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					EditText ed1 = (EditText) findViewById(R.id.userNameInsert);
					EditText ed2 = (EditText) findViewById(R.id.passwordInsert);
					String email = ed1.getText().toString();
					String pass = ed2.getText().toString();
					result = false;
					startConn = false;

					User user = new User();
					user.setEmail(email);
					user.setPassword(pass);
					CallerLogin caller = new CallerLogin(user);
					caller.join();
					caller.start();

					while (!startConn) {
						try {
							Thread.sleep(10);
						} catch (Exception ex) {
							System.out.println("Thread did not sleep!");
						}
					}
					if (result) {
						Intent intent = new Intent(LoginActivity.this, MainScreen.class);
						startActivity(intent);
						finish();
					} else if (!result) {
						Toast.makeText(getApplicationContext(), R.string._falseLogin, Toast.LENGTH_LONG).show();
						startConn = false;
					}
				} catch (Exception ex) {
					Toast.makeText(MyApplication.getContext(), R.string._errorConnection, Toast.LENGTH_LONG).show();
				}
			}
		};
	}

	@Override
	public void onBackPressed() {
		moveTaskToBack(true);
	}
}

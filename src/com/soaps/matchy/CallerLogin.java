package com.soaps.matchy;

import android.os.Looper;
import android.widget.Toast;

import com.main.matchy.R;
import com.screens.matchy.LoginActivity;
import com.screens.matchy.MyApplication;

public class CallerLogin extends Thread {
	public ConcreteLogin callLogin;
	private User _user;

	public CallerLogin(User user) {
		this._user = user;
	}

	public void run() {
		Looper.prepare();

		try {
			callLogin = new ConcreteLogin("Login2", "user", this._user);
			LoginActivity.result = callLogin.returnBoolean();
			LoginActivity.startConn = true;
		} catch (Exception ex) {
			MyApplication.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast.makeText(MyApplication.getContext(), R.string._errorConnection, Toast.LENGTH_LONG).show();
				}
			});
		}
	}
}
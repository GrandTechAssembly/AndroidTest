package com.soaps.matchy;

import com.screens.matchy.LoginActivity;

public class Caller extends Thread {
	public CallSoapLogin callLogin;
	public String email, pass;

	public void run() {
		try {
			callLogin = new CallSoapLogin();
			String response = callLogin.Call(email, pass);
			LoginActivity.result = response;

		} catch (Exception ex) {
			LoginActivity.result = ex.toString();
		}
	}
}
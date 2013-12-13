package com.soaps.matchy;

import org.ksoap2.serialization.SoapObject;

import android.widget.Toast;

import com.main.matchy.R;
import com.screens.matchy.MyApplication;

public class ConcreteLogin extends CallSoap {
	
	private User _user;

	public ConcreteLogin(String operation, String objectName, User user) {
		super(operation, objectName, user);
		this._user = user;
		
		newProperty();
		buildEnvelope();
	}

	@Override
	public Boolean returnBoolean() {
		try {
			CallSoap._httpTransport.call(SoapConstants.TARGET_NAMESPACE + SoapConstants.OPERATION, CallSoap._envelope);
			SoapObject response = (SoapObject) CallSoap._envelope.getResponse();
			this._user.setEmail(response.getProperty(0).toString());
			this._user.setPassword(response.getProperty(1).toString());
			this._user.setMayLogin(Boolean.parseBoolean(response.getProperty(2).toString()));
			return _user.getMayLogin();
		} catch (Exception exception) {
			Toast.makeText(MyApplication.getContext(), R.string._errorConnection, Toast.LENGTH_LONG).show();
			return null;
		}
	}

	@Override
	public Object returnObject() {
		return null;
	}

}

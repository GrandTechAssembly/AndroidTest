package com.soaps.matchy;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.screens.matchy.MyApplication;

import android.widget.Toast;

public class CallSoapLogin {

	public CallSoapLogin() {
	}

	/*
	 * Call method to Matchy webservice.
	 * Takes 2 strings as arguments and returns them to the webservice.
	 * Webservice checks validity of login parameters (webservice functionality).
	 */
	
	public String Call(String email, String pass) {
		SoapConstants soapConstants = new SoapConstants();
		SoapObject request = new SoapObject(soapConstants.TARGET_NAMESPACE, soapConstants.OPERATIONLOGIN);
		
		PropertyInfo propInfo = new PropertyInfo();
		propInfo.setNamespace(soapConstants.TARGET_NAMESPACE);
		propInfo.setName("email");
		propInfo.setValue(email);
		propInfo.setType(String.class);
		request.addProperty(propInfo);

		propInfo = new PropertyInfo();
		propInfo.setNamespace(soapConstants.TARGET_NAMESPACE);
		propInfo.setName("pass");
		propInfo.setValue(pass);
		propInfo.setType(String.class);
		request.addProperty(propInfo);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setAddAdornments(false);
		envelope.implicitTypes = true;
		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(soapConstants.ADDRESS);
		try {
			httpTransport.call(soapConstants.TARGET_NAMESPACE+soapConstants.OPERATIONLOGIN, envelope);
			final SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			return response.toString();
		} catch (Exception exception) {
        	Toast.makeText(MyApplication.getContext(), "Fout met verbinden naar de server, probeer het later nog eens", 
        			   Toast.LENGTH_LONG).show();
			return "0";
		}
	}
}
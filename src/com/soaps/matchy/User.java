package com.soaps.matchy;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class User implements KvmSerializable {

	/**
	 * 
	 */
	private String Email;
	private String Pass;
	private Boolean MayLogin = false;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Pass;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String Email) {
		this.Email = Email;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.Pass = password;
	}

	/**
	 * @return the mayLogin
	 */
	public Boolean getMayLogin() {
		return MayLogin;
	}

	/**
	 * @param mayLogin
	 *            the mayLogin to set
	 */
	public void setMayLogin(Boolean mayLogin) {
		MayLogin = mayLogin;
	}

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return Email;
		case 1:
			return Pass;
		case 2:
			return MayLogin;
		}

		return null;
	}

	@Override
	public int getPropertyCount() {
		return 3;
	}

	@SuppressWarnings("rawtypes") 
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
		case 0:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Email";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Pass";
			break;
		case 2:
			info.type = PropertyInfo.BOOLEAN_CLASS;
			info.name = "MayLogin";
			break;
		default:
			break;
		}
	}

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			Email = value.toString();
			break;
		case 1:
			Pass = value.toString();
			break;
		case 2:
			MayLogin = Boolean.parseBoolean(value.toString());
			break;

		default:
			break;
		}
	}

}

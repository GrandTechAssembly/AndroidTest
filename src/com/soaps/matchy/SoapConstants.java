package com.soaps.matchy;

public class SoapConstants {
	/**
	 * SOAP request information
	 */
	protected static String OPERATION;
	protected static String TARGET_NAMESPACE = "http://145.24.222.183/";
	protected static String ADDRESS = "http://145.24.222.183/matchy/WebService.asmx?wsdl";
	
	/**
	 * @param oPERATIONLOGIN the oPERATIONLOGIN to set
	 */
	public static void setOPERATION(String oPERATION) {
		OPERATION = oPERATION;
	}
}

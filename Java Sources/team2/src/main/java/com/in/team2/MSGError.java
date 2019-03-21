package com.in.team2;

public class MSGError extends Exception{ 
	private String message;
	private int errorCode;
	
	public MSGError(){}

	public String getMessage() {
		return message;
	}

	public void setMessage(Object expected, Object returned) {
		message="Result "+expected+" is expected, but "+returned+" is returned. Rollback";
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

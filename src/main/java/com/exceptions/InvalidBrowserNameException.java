package com.exceptions;

public class InvalidBrowserNameException extends RuntimeException{
	
	String browserName;
	
	public InvalidBrowserNameException(String browserName) {
		this.browserName = browserName;
	}
	
	@Override
	public String getMessage() {
		
		if (browserName.isEmpty())
			return "Browser Name not provided! ";
		else
			return "Browser Name is invalid! " + "\""+browserName+"\"" ;
	}

}

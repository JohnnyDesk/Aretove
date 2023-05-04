package com.generator;

import com.keywords.UIKeyword;

public class StepDefGenerator {
	
	public static void main(String[] args) {
		
		UIKeyword.stepDef("Given User Clicks on Pune Office Tab\r\n"
				+ "And User enters First Name\r\n"
				+ "And User enters Email\r\n"
				+ "And User enter Message \r\n"
				+ "And User Enters their Phone Number as 9009a09009\r\n"
				+ "When User Clicks on Submit\r\n"
				+ "Then Verify if User gets an error message");

	}

}

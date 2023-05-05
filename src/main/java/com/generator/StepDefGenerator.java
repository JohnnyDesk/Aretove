package com.generator;

import com.keywords.UIKeyword;

public class StepDefGenerator {
	
	public static void main(String[] args) {
		
		UIKeyword.stepDef("And User enters First Name as \"test\"\r\n"
				+ "And User enters Email as \"test@test.com\"\r\n"
				+ "And User enter Message as \"test\"");

	}

}

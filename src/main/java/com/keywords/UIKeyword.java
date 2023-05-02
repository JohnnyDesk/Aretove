package com.keywords;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class UIKeyword {
	
	/**
	 * Keyword which returns an ArrayList of String type 
	 * @param elements
	 * @return
	 */
	protected ArrayList<String> getListAsString(List<WebElement> elements) {
		
		ArrayList<String> al = new ArrayList<>();
		for (WebElement element : elements) {
			al.add(element.getText());
		}
		
		return al;
	}
	
	/**
	 * Provide the title of the window to which you want to switch to
	 * @param title
	 */
	protected void switchWindow(String title) {
		
	}

}

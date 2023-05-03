package com.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


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
	 * Provide Css locator and driver instance to click on a element using JavaScript
	 * @param csslocator
	 * @param driver
	 */
	protected void clickWithJS(String csslocator, RemoteWebDriver driver) {
		driver.executeScript("document.querySelector('"+csslocator+"').click()");
	}
	
	/**
	 * Provide WebElement and driver instance to click on a element using JavaScript
	 * @param element
	 * @param driver
	 */
	protected void clickWithJS(WebElement element, RemoteWebDriver driver) {
		driver.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * Provide WebElement, Text to enter and driver instance to Enter Text in a TextBox using JavaScript
	 * @param element
	 * @param text
	 * @param driver
	 * 
	 */
	protected void enterTextWithJS(WebElement element, String text, RemoteWebDriver driver) {
		driver.executeScript("arguments[0].value='"+text+"'", element);
	}
	
	
	/**
	 * User for hovering over a specific WebElement element
	 * @param element
	 * @param driver
	 */
	protected void hoverOnElement(WebElement element, RemoteWebDriver driver) {
		Actions action = new Actions(driver);
		
		action.moveToElement(element).perform();
		
	}
	
	/**
	 * Hit a keyboard key using Java's Robot class, by provdining int keycode or KeyEvent
	 * @param driver
	 * @param keycode
	 */
	protected void pressKey(RemoteWebDriver driver, int keycode) {
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		robo.keyPress(keycode);
		robo.keyRelease(keycode);
		
	}
	
	
	/**
	 * Step Definition Generator
	 * @param String Step with keyword
	 */
	public static void singleStep(String s) {

		String keyword = s.split(" ")[0];

		String methodName = s.substring(keyword.length() + 1);

		keyword = "@" + keyword;
		String stepName = keyword + " (\"" + methodName + "\")";

		methodName = methodName.replace(" ", "_");

		methodName = "public void "+ methodName+"(){\n\n}";
		
		System.out.println(stepName);
		System.out.println(methodName);

	}
	
	
	
	/**
	 * Provide the title of the window to which you want to switch to
	 * @param title
	 */
	protected void switchWindow(String title) {
		
	}
	
	

}

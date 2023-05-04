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
	 * 
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
	 * Provide Css locator and driver instance to click on a element using
	 * JavaScript
	 * 
	 * @param csslocator
	 * @param driver
	 */
	protected void clickWithJS(String csslocator, RemoteWebDriver driver) {
		driver.executeScript("document.querySelector('" + csslocator + "').click()");
	}

	/**
	 * Provide WebElement and driver instance to click on a element using JavaScript
	 * 
	 * @param element
	 * @param driver
	 */
	protected void clickWithJS(WebElement element, RemoteWebDriver driver) {
		driver.executeScript("arguments[0].click()", element);
	}

	/**
	 * Provide WebElement, Text to enter and driver instance to Enter Text in a
	 * TextBox using JavaScript
	 * 
	 * @param element
	 * @param text
	 * @param driver
	 * 
	 */
	protected void enterTextWithJS(WebElement element, String text, RemoteWebDriver driver) {
		driver.executeScript("arguments[0].value='" + text + "'", element);
	}

	/**
	 * User for hovering over a specific WebElement element
	 * 
	 * @param element
	 * @param driver
	 */
	protected void hoverOnElement(WebElement element, RemoteWebDriver driver) {
		Actions action = new Actions(driver);

		action.moveToElement(element).perform();

	}

	/**
	 * Hit a keyboard key using Java's Robot class, by provdining int keycode or
	 * KeyEvent
	 * 
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
	 * 
	 * @param String Step with keyword
	 */
	public static void stepDef(String s) {

		String[] steps = s.split("\n");

//		Auto Imports
		for (String step : steps) {
			String firstWord = step.split(" ")[0];
			
			if (firstWord.equals("Given")) {
				System.out.println("import io.cucumber.java.en.Given;");
			}
			if (firstWord.equals("When")) {
				System.out.println("import io.cucumber.java.en.When;");
			}
			if (firstWord.equals("Then")) {
				System.out.println("import io.cucumber.java.en.Then;");
			}
			if (firstWord.equals("And")) {
				System.out.println("import io.cucumber.java.en.And;");
			}
			if (firstWord.equals("But")) {
				System.out.println("import io.cucumber.java.en.But;");
			}
		}

		System.out.println();

//		Step Definition Generator

		int numOfSteps = steps.length - 1;

		String cleanStep = new String();
		String keyword = new String();
		String parameter = new String();
		String methodName = new String();

		for (int i = 0; i <= numOfSteps; i ++) {
			cleanStep = steps[i].trim();
			
			keyword = cleanStep.split(" ")[0];
			parameter = cleanStep.substring(keyword.length()+1);
			
//			Creating Method Name
			methodName = "public void " + parameter.toLowerCase().replace("\"", "").replace(" ", "_")+"(){\n\n}";
//			Creating Annotation
			keyword = "@"+keyword;
//			Creating Parameter
			parameter = parameter.replaceAll("\"([^\"]*)\"", "{string}");
			parameter = "(\"" + parameter + "\")";
			
			System.out.println(keyword+parameter);
			System.out.println(methodName);
		}

	}

	/**
	 * Provide the title of the window to which you want to switch to
	 * 
	 * @param title
	 */
	protected void switchWindow(String title) {

	}

}

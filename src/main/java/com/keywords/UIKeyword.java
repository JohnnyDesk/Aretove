package com.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIKeyword {
	
	Wait<RemoteWebDriver> fluentWait = null;
	
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
	 * @param WebElement 
	 * @param text to Enter
	 * @param driver instance
	 * 
	 */
	protected void enterTextWithJS(RemoteWebDriver driver, WebElement element, String text) {
		driver.executeScript("arguments[0].value='" + text + "'", element);
	}
	
	/**
	 * Provide WebElement css locator, Text to enter and driver instance to Enter Text in a
	 * TextBox using JavaScript
	 * @param driver instance
	 * @param String csslocator of webelement
	 * @param text to enter
	 */
	protected void enterTextWithJS(RemoteWebDriver driver, String csslocator, String text) {
		driver.executeScript("document.querySelector(\""+csslocator+"\").value='"+text+"'");
	}
	
	/**
	 * 
	 * @param driver
	 * @param csslocator
	 * @return
	 */
	protected String getTextWithJS(RemoteWebDriver driver, String csslocator) {
		return driver.executeScript("return document.querySelector(\""+csslocator+"\").innerText").toString();
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
	 * KeyEvent event
	 * 
	 * @param driver
	 * @param keycode
	 */
	protected void pressKey(int keycode) {
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
	 * Scroll window by pixels, to Scroll up put negative value
	 * @param x
	 * @param y
	 */
	protected void scrollWindow(int xAxis, int yAxis,RemoteWebDriver driver) {
//		driver.executeScript("window.scrollBy("+xAxis+","+yAxis+")");
		driver.executeScript("window.scrollBy(arguments[0],arguments[1])", xAxis,yAxis);
	}

		
	/**
	 * Puts current thread to sleep and handles exception
	 * @param milliSeconds
	 */
	protected void sleepThreadFor(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a instance of fluent wait
	 * @param RemoteWebDriver driver instance
	 * @return
	 */
	public Wait<RemoteWebDriver> waitScript(RemoteWebDriver driver) {
		fluentWait = new FluentWait<RemoteWebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);
		
		WebDriver dr = new EdgeDriver();
		
		WebDriverWait wait = new WebDriverWait(dr, 60);
		wait.pollingEvery(Duration.ofMillis(500));
		
		
		return fluentWait;
	}


}

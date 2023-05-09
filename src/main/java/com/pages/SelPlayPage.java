package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.keywords.UIKeyword;

public class SelPlayPage extends UIKeyword {

	RemoteWebDriver driver;

	/** =================== Constructor =================== **/

	public SelPlayPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** =================== Elements =================== **/

	@FindBy(xpath = "//a[text()='Select Dropdown List']")
	private WebElement selectDropDownListDemo;

	@FindBy(xpath = "//a[text()='Window Popup Modal']")
	private WebElement windowPopupDemo;

	@FindBy(css = "select#select-demo")
	private WebElement singleSelectList;

	@FindBy(css = "select#select-demo")
	private List<WebElement> singleSelectListOptions;

	@FindBy(css = "select#multi-select")
	private WebElement multiSelectList;

	@FindBy(css = "a#followall")
	private WebElement followAllBTN;

	/** =================== Element Actions =================== **/

	public void click_on_selectDropDownListDemo() {
		selectDropDownListDemo.click();
	}

	public List<String> getOptionsFromList() {
		Select sel = new Select(singleSelectList);

		return getListAsString(sel.getOptions());
	}

	public void selectOptionFromList(int index) {
		Select sel = new Select(singleSelectList);
		sel.selectByIndex(index);
		sleepThreadFor(5000);
	}

	public void selectOptionFromList(String visibleText) {
		Select sel = new Select(singleSelectList);
		sel.selectByVisibleText(visibleText);
		sleepThreadFor(5000);
	}

	public List<String> getOptionsFromMultiList() {
		Select sel = new Select(multiSelectList);

		return getListAsString(sel.getOptions());
	}

	public void selectOptionFromMultiList(int index) {
		Select sel = new Select(multiSelectList);
		sel.selectByIndex(index);
		sleepThreadFor(5000);
	}

	public void selectOptionFromMultiList(String visibleText) {
		Select sel = new Select(multiSelectList);
		sel.selectByVisibleText(visibleText);
		sleepThreadFor(5000);
	}

	public void click_On_WindowPopupDemo() {
		windowPopupDemo.click();
	}

	public void click_On_FollowAllBTN() {
		followAllBTN.click();
		sleepThreadFor(5000);
	}

	public String getCurrentWindowHandle() {
		String currentWindow = driver.getWindowHandle();
		return currentWindow;
	}

	public void switchToWindow(String windowTitle, String currentWindow) {
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> itr = windowHandles.iterator();
		
		while (itr.hasNext()) {
			String title = driver.getTitle();
			String nextWindow = itr.next();
			if (title != windowTitle) {
				driver.switchTo().window(nextWindow);
			}
		}
	}
	
	public void getAllWindowTitles() {
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> itr = windowHandles.iterator();
		
		while (itr.hasNext()) {
			String title = driver.getTitle();
			System.out.println(title);
			driver.switchTo().window(itr.next());
		}
	}

}

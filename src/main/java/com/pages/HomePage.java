package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.keywords.UIKeyword;

public class HomePage extends UIKeyword {

	private RemoteWebDriver driver;

	/** =================== Constructor =================== **/

	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** =================== WebElements =================== **/

	@FindBy(xpath = "//*[@id=\"slider-1-slide-52-layer-4\"]/a")
	private WebElement servicesBTN;

	@FindBy(css = "li#menu-item-2600")
	private WebElement aboutBTN;

	@FindBy(css = "div[class^=\"logo media-left\"]")
	private WebElement logoMain;

	@FindBy(css = "h2.consulting-custom-title")
	private List<WebElement> headings;

	@FindBy(css = "ul#menu-extra-links>li")
	private List<WebElement> navTabs;
	
	@FindBy(css = "li#menu-item-2842")
	private WebElement careersTab;
	
	@FindBy(css = "li#menu-item-43820")
	private WebElement blogTab;
	
	@FindBy(css = "a.social-facebook")
	private WebElement facebookBTN;
	
	@FindBy(css = "a.social-twitter")
	private WebElement twitterBTN;
	
	@FindBy(css = "a.social-linkedin")
	private WebElement linkedinBTN;
	
	@FindBy(css = "a[href=\"https://www.aretove.com/contact-us\"]")
	private WebElement contactBTN;
	
	@FindBy(css = "ul.vc_tta-tabs-list li:nth-child(2)")
	private WebElement puneOfficeTab;
	
	@FindBy(css = "div.request_callback input[name=\"text-name\"]")
	private WebElement firstNameTxtBox;

	/** =================== Element Actions =================== **/

	public void click_On_ServicesBTN() {
		driver.get("https://www.aretove.com/services-grid");
	}

	public String get_page_title() {
		return driver.getTitle();
	}

	public void click_On_AboutBTN() {
		aboutBTN.click();
	}

	public void click_On_Logo() {
		logoMain.click();
	}

	public ArrayList<String> list_Of_headings() {
		return getListAsString(headings);
	}

	public ArrayList<String> list_of_navTabs() {
		return getListAsString(navTabs);
	}
	
	public void click_On_navTab(String navTabName) {
		
		if (navTabName.equals("Careers")) {
			careersTab.click();
		}else if (navTabName.equals("Blog")) {
			blogTab.click();
		}
	}
	
	public void click_On_Social(String siteName) {
		
		if(siteName.equals("Facebook")) {
			facebookBTN.click();
		}else if(siteName.equals("Twitter")) {
			twitterBTN.click();
		}else if(siteName.equals("LinkedIn")) {
			linkedinBTN.click();
		}
	}
	
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}
	
	public Set<String> getAllWindowHandles() {
		return driver.getWindowHandles();
	}
	
	public String switchWindow(String title, String mainhandle) {
		
		Set<String> handles = getAllWindowHandles();
		
		Iterator<String> itr = handles.iterator();
		
		for (String handle : handles) {
			if (!handle.equals(mainhandle)) {
				driver.switchTo().window(handle);
			return driver.getTitle();
			}

		}
		
		return null;
	}
	
	
	public void click_On_ContactBTN() {
		clickWithJS(contactBTN, driver);
	}
	
	public void click_On_PuneOfficeTab() {
		puneOfficeTab.click();
	}
	
	
	public void enter_text_First_Name() {
		enterTextWithJS(firstNameTxtBox, "Sandesh", driver);
	}

}

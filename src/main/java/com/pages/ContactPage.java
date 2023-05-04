package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.DriverFactory;
import com.keywords.UIKeyword;

public class ContactPage extends UIKeyword{
	
	private RemoteWebDriver driver = DriverFactory.getDriver();
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "ul.vc_tta-tabs-list li:nth-child(2)")
	private WebElement puneOfficeTab;
	
	public void click_On_PuneOfficeTab() {
		puneOfficeTab.click();
	}

}

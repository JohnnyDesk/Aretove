package com.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private RemoteWebDriver driver;

	/** =================== Constructor =================== **/

	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** =================== WebElements =================== **/

	/** =================== Element Actions =================== **/

}

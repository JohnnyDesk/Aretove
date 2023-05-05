package com.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.keywords.UIKeyword;

public class ContactPage extends UIKeyword{
	
	private RemoteWebDriver driver;

	/** =================== Constructor =================== **/
	
	public ContactPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/** =================== Elements =================== **/
	
	@FindBy(css = "li[class='vc_tta-tab'] span[class='vc_tta-title-text']")
	private WebElement puneOfficeTab;
	
	@FindBy(css = "div#wpcf7-f508-p11-o2 input[placeholder='First name *']")
	private WebElement puneFormFirstName;

	@FindBy(css = "div#wpcf7-f508-p11-o2 input[placeholder='E-mail *']")
	private WebElement puneFormEmail;
	
	@FindBy(css = "div#wpcf7-f508-p11-o2 textarea[placeholder='Your Message *']")
	private WebElement puneFormMsg;
	
	@FindBy(css = "div#wpcf7-f508-p11-o2 input[placeholder='Phone *']")
	private WebElement puneFormPhonNumber;

	@FindBy(css = "div#wpcf7-f508-p11-o2 button[type='submit']")
	private WebElement submitBtn;
	
	@FindBy(css = "div#wpcf7-f508-p11-o2 div.wpcf7-response-output")
	private WebElement formResponse;
	
	
	/** =================== Element Actions =================== **/
	
	public void click_On_PuneOfficeTab() {
		scrollWindow(0,150,driver);
		clickWithJS(puneOfficeTab, driver);
		sleepThreadFor(3000);
	}
	
	public void enter_Text_FirstName(String text) {
		enterTextWithJS(driver, puneFormFirstName, text);
	}

	public void enter_Text_Email(String email) {
		enterTextWithJS(driver, puneFormEmail, email);
	}

	public void enter_Text_Msg(String message) {
		String loc = "div[id='wpcf7-f508-p11-o2'] textarea[placeholder='Your Message *']";
		enterTextWithJS(driver, loc, message);
	}

	public void enter_Text_PhoneNumber(String number) {
		puneFormPhonNumber.sendKeys(number);
	}

	public void click_On_SubmitBtn() {
		submitBtn.click();
		sleepThreadFor(5000);
	}
	
	public String get_FormResponse() {
		String response = formResponse.getText();
		return response;
	}
	
	
	
	

}

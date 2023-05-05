package stepdefinitions;

import io.cucumber.java.en.Given;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.base.DriverFactory;
import com.keywords.UIKeyword;
import com.pages.ContactPage;
import com.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ContactPageSteps {

	ContactPage contactPage = new ContactPage(DriverFactory.getDriver());
	HomePage homepage = new HomePage(DriverFactory.getDriver());

	@Given("Application Homepage is open and User clicks on Contact option in the top header")
	public void application_homepage_is_open_and_user_clicks_on_contact_option_in_the_top_header() {
		DriverFactory.getDriver().get("https://www.aretove.com/");
		homepage.click_On_ContactBTN();
	}

	@Given("User Clicks on Pune Office Tab")
	public void user_Clicks_on_Pune_Office_Tab() {
		contactPage.click_On_PuneOfficeTab();
	}

	@And("User enters First Name as {string}")
	public void user_enters_first_name(String name){
		contactPage.enter_Text_FirstName(name);
	}
	@And("User enters Email as {string}")
	public void user_enters_email(String email){
		contactPage.enter_Text_Email(email);
	}
	@And("User enter Message as {string}")
	public void user_enter_message(String message){
		contactPage.enter_Text_Msg(message);
	}

	@And("User Enters their Phone Number as {string}")
	public void user_Enters_their_Phone_Number(String number) {
		contactPage.enter_Text_PhoneNumber(number);
	}

	@When("User Clicks on Submit")
	public void user_Clicks_on_Submit() {
		contactPage.click_On_SubmitBtn();
	}

	@Then("Verify if User gets an error message")
	public void verify_if_User_gets_an_error_message() {
		String expectedMsg = "Please rectify";
		String actualMsg = contactPage.get_FormResponse();
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Unexpected Response: " + actualMsg);
	}
	

}

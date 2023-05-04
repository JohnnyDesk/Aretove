package stepdefinitions;

import io.cucumber.java.en.Given;

import com.base.DriverFactory;
import com.pages.ContactPage;
import com.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ContactPageSteps {

	ContactPage contactPage = new ContactPage();
	HomePage homepage = new HomePage(DriverFactory.getDriver());

	@Given("Application Homepage is open and user clicks on Contact option in the top header")
	public void application_Homepage_is_open_and_user_clicks_on_Contact_option_in_the_top_header() {
		DriverFactory.getDriver().get("https://www.aretove.com/");
		contactPage = homepage.click_On_ContactBTN();
		
	}

	@Given("User Clicks on Pune Office Tab")
	public void user_Clicks_on_Pune_Office_Tab() {
		contactPage.click_On_PuneOfficeTab();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("User enters First Name")
	public void user_enters_First_Name() {

	}

	@And("User enters Email")
	public void user_enters_Email() {

	}

	@And("User enter Message")
	public void user_enter_Message() {

	}

	@And("User Enters their Phone Number as 9009a09009")
	public void user_Enters_their_Phone_Number_as_9009a09009() {

	}

	@When("User Clicks on Submit")
	public void user_Clicks_on_Submit() {

	}

	@Then("Verify if User gets an error message")
	public void verify_if_User_gets_an_error_message() {

	}

}

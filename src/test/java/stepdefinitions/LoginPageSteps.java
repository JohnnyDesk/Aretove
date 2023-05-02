package stepdefinitions;

import org.testng.Assert;

import com.base.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("Application HomePage is open")
	public void appUrl() {
		DriverFactory.getDriver().get("https://www.aretove.com/");
	}

	@Given("^User is on Net Banking landing page$")
	public void user_is_on_net_banking_landing_page() {
		System.out.println("net banking landing page");
	}

	@When("User logins to the application as {string} and {string}")
	public void user_logins_to_the_application_with_username_and_password(String name1, String name2) {
		System.out.println("logins to the application as " + name1 + " and " + name2);
	}

	@Then("^Home Page is displayed$")
	public void home_page_is_displayed() {
		System.out.println("Home Page is displayed");
	}

	@And("^Cards are displayed$")
	public void cards_are_displayed() {
		System.out.println("Cards are displayed");
	}
	
	@And("This should fail")
	public void this_fails() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(true, false);
	}

}

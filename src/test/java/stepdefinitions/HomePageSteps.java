package stepdefinitions;

import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.base.DriverFactory;
import com.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	private HomePage homepage = new HomePage(DriverFactory.getDriver());
	private String tempString;
	private String homeWindow;
	
	@Given("Application Homepage is open")
	public void launchApp() {
		DriverFactory.getDriver().get("https://www.aretove.com/");
	}
	
	 @Given("User clicks on the Services Button from the Image carousel")
	    public void user_clicks_on_the_services_button_from_the_image_carousel(){
		 homepage.click_On_ServicesBTN();
	    }

	    @Then("Verify if {string} Page is displayed")
	    public void verify_if_services_page_is_displayed(String expPageTitle){
	    	String actualpageTitle = homepage.get_page_title();
	    	Assert.assertTrue(actualpageTitle.contains(expPageTitle), "Actual Page Title is: " + actualpageTitle);
	    }
	    
	    @Given("User clicks on the About button in the top header")
	    public void user_clicks_on_the_about_button_in_the_top_header() {
	    	homepage.click_On_AboutTab();
	    }
	    
	    @Given("On Homepage verify if {string} is Diplayed")
	    public void on_homepage_verify_if_some_section_is_diplayed(String strArg1) {
	    	System.out.println(strArg1);
	    	Assert.assertTrue(homepage.list_Of_headings().contains(strArg1));
	    }
	    
	    @Given("On Homepage verify if <Tabs> is present in Header")
	    public void on_homepage_verify_if_is_present_in_header(List<String> tabName) {
	    	Assert.assertTrue(homepage.list_of_navTabs().equals(tabName), "List does not match");
	    }
	    
	    @Given("User clicks on a {string} in the top header")
	    public void user_clicks_on_a_in_the_top_header(String navigationtab) {
	    	homepage.click_On_navTab(navigationtab);
	    	this.tempString = navigationtab;
	    }

	    @Then("Verify if Related Page is displayed")
	    public void verify_if_related_page_is_displayed() {
	    	Assert.assertTrue(homepage.get_page_title().contains(tempString));
	    }
	    
	    @Given("User clicks on {string} icon in the footer")
	    public void user_clicks_on_social_icon_in_the_footer(String socialAccount) {
	    	homeWindow = homepage.getCurrentWindowHandle();
	    	homepage.click_On_Social(socialAccount);
	    	this.tempString = socialAccount;
	    	
	    	System.out.println("Home Window " + homeWindow);
	    	System.out.println(homepage.getAllWindowHandles()); 
	    }

	    @Then("Verify if new tab or window opens up with the related social account")
	    public void verify_if_new_tab_or_window_opens_up_with_the_companys_facebook_account() {
	    	
	    	String newWindowTitle = homepage.switchWindow(tempString, homeWindow);
	    	Assert.assertTrue(newWindowTitle.contains(tempString), " Redirected to incorrect page");
	    	
	    }	    
}

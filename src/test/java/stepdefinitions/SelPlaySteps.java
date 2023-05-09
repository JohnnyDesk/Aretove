package stepdefinitions;

import com.base.DriverFactory;
import com.pages.SelPlayPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SelPlaySteps {

	SelPlayPage playPage = new SelPlayPage(DriverFactory.getDriver());

	@Given("Browser Navigates to Selenium Playground HomePage")
	public void browser_navigates_to_selenium_playground_homepage() {
		DriverFactory.getDriver().get("https://www.lambdatest.com/selenium-playground");
	}

	@Given("User Selects Select Dropdown List Demo on Homepage")
	public void user_selects_select_dropdown_list_demo_on_homepage() {
		playPage.click_on_selectDropDownListDemo();
	}

	@Given("Select the {int}rd value from the list")
	public void select_the_3rd_value_from_the_list(int index) {
		playPage.selectOptionFromList(index);
	}

	@Then("Select {string} from the list")
	public void select_friday_from_the_list(String day) {
		playPage.selectOptionFromList(day);
	}

	@Given("Select the {int}nd value from the multi select list")
	public void select_the_2nd_value_from_the_multi_select_list(int index) {
		playPage.selectOptionFromMultiList(index);
	}

	@Then("Select {string} from the multi select list")
	public void select_friday_from_the_multi_select_list(String visibleText) {
		playPage.selectOptionFromMultiList(visibleText);
	}

	@Given("User Selects Window Popup Modal Demo on")
	public void user_selects_window_popup_modal_demo_on() {
		playPage.click_On_WindowPopupDemo();
	}

	@Then("Switches to every Window and gets their title")
	public void switches_to_every_window_and_gets_their_title() {
		playPage.click_On_FollowAllBTN();
		playPage.getAllWindowTitles();
	}
}

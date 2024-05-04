package com.automation.steps;

import com.automation.pages.BasePage;
import com.automation.pages.FlightSearchPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightSearchSteps {

	FlightSearchPage flightSearchPage = new FlightSearchPage();
	@Then("verify user is on flight search screen")
	public void verify_user_is_on_flight_search_screen() {
		Assert.assertTrue(flightSearchPage.isFlightSearchScreen());
	}

	@When("user enters source to {string}")
	public void userEntersSourceTo(String source) {
		flightSearchPage.enterSourceLocation(ConfigReader.getProperty(source));
	}

	@And("flight destination to {string}")
	public void flightDestinationTo(String destination) {
		flightSearchPage.enterDestinationLocation(ConfigReader.getProperty(destination));
	}

	@And("select date from {string} to {string}")
	public void selectDateFromTo(String travelDate, String returnDate) {
		flightSearchPage.enterDate(ConfigReader.getProperty(travelDate));
		flightSearchPage.enterDate(ConfigReader.getProperty(returnDate));
	}

	@And("click on done button")
	public void clickOnDoneButton() {
		flightSearchPage.clickDoneBnt();
	}

	@And("click on search button")
	public void clickOnSearchButton() {
		flightSearchPage.clickOnSearchButton();
		
	}

	@Then("verify invalid search error is displayed with text")
	public void verifyInvalidSearchErrorIsDisplayedWithText(String message) {
		Assert.assertTrue(flightSearchPage.isSameLocationErrorIsDisplayed());
		Assert.assertEquals(message,flightSearchPage.getSameLocationErrorMessage());

	}

	@And("click on done button on invalid search error popup")
	public void clickOnDoneButtonOnInvalidSearchErrorPopup() {
		flightSearchPage.clickOnDoneButtonOnInvalidSearchErrorPopup();
	}


}

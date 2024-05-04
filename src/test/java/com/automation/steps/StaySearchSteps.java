package com.automation.steps;

import com.automation.pages.StaySearchPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StaySearchSteps {
	StaySearchPage staySearchPage = new StaySearchPage();
	@And("user enters stay location {string}")
	public void userEntersStayLocation(String location) {
		staySearchPage.enterDestinationLocation(ConfigReader.getProperty(location));
	}

	@And("select date check-in date {string}")
	public void selectDateCheckInDate(String checkInDate) {
		staySearchPage.enterDate(ConfigReader.getProperty(checkInDate));

	}

	@And("checkout date {string}")
	public void checkoutDate(String checkOutDate) {
		staySearchPage.enterDate(ConfigReader.getProperty(checkOutDate));
	}


	@And("user click on date field")
	public void userClickOnDateField() {
		staySearchPage.clickOnDateField();
	}
}

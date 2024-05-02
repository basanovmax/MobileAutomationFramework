package com.automation.steps;

import com.automation.pages.FlightListingPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FlightListingSteps {
	FlightListingPage flightListingPage = new FlightListingPage();
	@Then("verify flight listing page is displayed")
	public void verifyFlightListingPageIsDisplayed() {
		Assert.assertTrue(flightListingPage.isFlightListingPageDisplayed());
	}
}

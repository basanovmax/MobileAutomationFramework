package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightListingPage extends BasePage{
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Price Tracking']")
	WebElement priceTrackingText;
	public boolean isFlightListingPageDisplayed() {
	return priceTrackingText.isDisplayed();

	}
}

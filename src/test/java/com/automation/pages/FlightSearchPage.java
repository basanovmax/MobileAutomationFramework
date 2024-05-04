package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightSearchPage  extends SearchPage{


	@FindBy(xpath = "//android.widget.TextView[@text='Flying from']")
	WebElement flyingFromField;

	@FindBy(xpath = "//android.widget.TextView[@text='Flying to']")
	WebElement flyingToField;



	@FindBy(xpath = "//android.widget.TextView[@text='Travelers']")
	WebElement travellersField;

	@FindBy(xpath = "//android.widget.TextView[@text='Preferred class']")
	WebElement preferredClassField;



	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.expedia.bookings:id/udsInputFieldLabel' and @text='Flying from']")
	WebElement flyingFromBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.expedia.bookings:id/udsInputFieldLabel' and @text='Flying to']")
	WebElement flyingToBtn;

	@FindBy(xpath = "//android.widget.TextView[@content-desc='Price Tracking']")
	WebElement contentCard;
	@FindBy(id = "com.expedia.bookings:id/parentPanel")
	WebElement sameLocationErrorPopUp;
	@FindBy(id = "android:id/message")
	WebElement sameLocationErrorMsg;
	@FindBy(id = "android:id/button1")
	WebElement sameLocationErrorDoneBtn;

	public boolean isFlightSearchScreen() {
		return flyingFromField.isDisplayed() && flyingToField.isDisplayed()&&dateField.isDisplayed()&&travellersField.isDisplayed()&&preferredClassField.isDisplayed()&&searchBtn.isDisplayed();
	}

	public void enterSourceLocation(String source) {
		flyingFromBtn.click();
		searchBox.sendKeys(source);
		searchResultList.get(0).click();
	}



	public boolean isFlightListingPage() {
		return contentCard.isDisplayed();
	}


	public boolean isSameLocationErrorIsDisplayed() {
	return sameLocationErrorPopUp.isDisplayed();
	}

	public String getSameLocationErrorMessage() {
		return sameLocationErrorMsg.getText();
	}

	public void clickOnDoneButtonOnInvalidSearchErrorPopup() {
		sameLocationErrorDoneBtn.click();
	}
}

package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightSearchPage  extends BasePage{


	@FindBy(xpath = "//android.widget.TextView[@text='Flying from']")
	WebElement flyingFromField;

	@FindBy(xpath = "//android.widget.TextView[@text='Flying to']")
	WebElement flyingToField;

	@FindBy(xpath = "//android.widget.TextView[@text='Select dates']")
	WebElement dateField;

	@FindBy(xpath = "//android.widget.TextView[@text='Travelers']")
	WebElement travellersField;

	@FindBy(xpath = "//android.widget.TextView[@text='Preferred class']")
	WebElement preferredClassField;

	@FindBy(id = "com.expedia.bookings:id/search_btn")
	WebElement searchBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.expedia.bookings:id/udsInputFieldLabel' and @text='Flying from']")
	WebElement flyingFromBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.expedia.bookings:id/udsInputFieldLabel' and @text='Flying to']")
	WebElement flyingToBtn;


	@FindBy(id = "com.expedia.bookings:id/search_src_text")
	WebElement searchBox;

	@FindBy(xpath = "(//android.widget.LinearLayout[@resource-id='com.expedia.bookings:id/suggestion_text_container'])")
	List<WebElement> searchResultList;

	String XPATH_DATE_ELEMENT = "//android.widget.TextView[@content-desc='%s, Not Selected']";


	@FindBy(id = "com.expedia.bookings:id/confirmButton")
	WebElement doneBtn;

	@FindBy(xpath = "//android.widget.TextView[@content-desc='Price Tracking']")
	WebElement contentCard;


	public boolean isFlightSearchScreen() {
		return flyingFromField.isDisplayed() && flyingToField.isDisplayed()&&dateField.isDisplayed()&&travellersField.isDisplayed()&&preferredClassField.isDisplayed()&&searchBtn.isDisplayed();
	}

	public void enterSourceLocation(String source) {
		flyingFromBtn.click();
		searchBox.sendKeys(source);
		searchResultList.get(0).click();

	}

	public void enterDestinationLocation(String destination) {
		searchBox.sendKeys(destination);
		searchResultList.get(0).click();
	}

	public void enterDate(String date){
		String dateLoc = String.format(XPATH_DATE_ELEMENT, date);
		driver.findElement(By.xpath(dateLoc)).click();
	}


	public void clickDoneBnt() {
		doneBtn.click();
	}


	public void clickOnSearchButton() {
		searchBtn.click();
	}

	public boolean isFlightListingPage() {
		return contentCard.isDisplayed();
	}


}

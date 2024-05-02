package com.automation.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {

	@FindBy(xpath = "//android.widget.TextView[@text='Get started']")
	WebElement getStartedBtn;

	@FindBy(xpath = "//android.view.View[@content-desc='Close']")
	WebElement closeBtn;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	WebElement allow;

	@FindBy(xpath = "//android.widget.TextView[@text='Stays']")
	WebElement staysTab;

	@FindBy(xpath = "//android.widget.TextView[@text='Flights']")
	WebElement flightTab;

	public void openApplication() {
		//closing preload home screen popup windows
		click(getStartedBtn);
		click(closeBtn);
		click(allow);
	}


	public boolean isHomePageDisplayed() {
		return staysTab.isDisplayed() && flightTab.isDisplayed();
	}

	public void clickOnFlightTab() {
		flightTab.click();
	}
}





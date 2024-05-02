package com.automation.pages;

import com.automation.utils.DriverUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class BasePage {

	public AppiumDriver driver;

	public BasePage() {
		driver = DriverUtils.getDriver();
		PageFactory.initElements(driver, this);
	}
	public void click(WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
	}
}

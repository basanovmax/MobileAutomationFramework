package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverUtils {

	static AppiumDriver driver;

	// Method to create a driver, and it will get called from Hooks @Before
	public static void createLocalDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", ConfigReader.getProperty("platform.name"));
		capabilities.setCapability("deviceName", ConfigReader.getProperty("device.name"));
		capabilities.setCapability("appium:app", System.getProperty("user.dir") +"\\" + ConfigReader.getProperty("apk.name"));
		capabilities.setCapability("appium:automationName", ConfigReader.getProperty("automation.name"));

		//Create driver
		driver = new AppiumDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public static void createBSDriver() throws MalformedURLException {
		// Use Java Client v6.0.0 or above
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("projectName", "ExpediaAutomation");
		browserstackOptions.put("buildName", "RegressionTest");
		browserstackOptions.put("appiumVersion", "1.17.0");
		browserstackOptions.put("userName", "maxbasan_cKZg6x");
		browserstackOptions.put("accessKey", "TDLySduqvNy8SsfktzYH");

		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("deviceName", "Google Pixel 3");
		capabilities.setCapability("app", "https://www.apkmirror.com/apk/expedia/expedia-hotels-flights-cars/expedia-hotels-flights-cars-2024-17-0-release/expedia-hotels-flights-car-2024-17-0-android-apk-download/download/?key=4e5a2476842854386bbbba3d0efb03e06deeec61");

		URL url = new URL("http://hub-cloud.browserstack.com/wd/hub");

		driver = new AppiumDriver(url, capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	// Anywhere we need a driver, we will call this method
	public static AppiumDriver getDriver() {
		return driver;
	}

/* //This is creating for testing purpose, we can create 	at any class to test our methods just like unit testing
public static void main(String[] args) {
*//*		ConfigReader.loadProperties();
		System.out.println(ConfigReader.getProperty("platform.name"));*//*

		System.out.println(System.getProperty("os.name"));

		//Show where project dir
		System.out.println(System.getProperty("user.dir"));
	}*/
}

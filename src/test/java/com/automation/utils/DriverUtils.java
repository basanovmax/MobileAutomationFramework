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
		browserstackOptions.put("projectName", ConfigReader.getProperty("project.name"));
		browserstackOptions.put("userName", ConfigReader.getProperty("bs.username"));
		browserstackOptions.put("accessKey", ConfigReader.getProperty("bs.access.key"));
		browserstackOptions.put("buildName", ConfigReader.getProperty("build.name"));

		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("platformName", ConfigReader.getProperty("platform.name"));
		capabilities.setCapability("platformVersion", ConfigReader.getProperty("platform.version"));
		capabilities.setCapability("deviceName", ConfigReader.getProperty("bs.device.name"));
		capabilities.setCapability("app", ConfigReader.getProperty("bs.app.url"));

		URL url = new URL(ConfigReader.getProperty("bs.url"));

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

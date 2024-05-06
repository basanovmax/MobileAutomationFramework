package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks {

	@Before
	public void setUp() throws MalformedURLException {
		ConfigReader.loadProperties();
		//Jenkins Parameter
		String environment = System.getProperty("execution.platform");

		// If we do not get parameters from Jenkins, consider config file parameter
		if (environment == null){
			environment = ConfigReader.getProperty("execution.platform");
		}
		if (environment.equalsIgnoreCase("Local")) {
			DriverUtils.createLocalDriver();
		} else {
			DriverUtils.createBSDriver();
		}
	}


	@After
	public void tearDown() {
		//DriverUtils.getDriver() call driver
		//DriverUtils.getDriver().quit();
	}
}

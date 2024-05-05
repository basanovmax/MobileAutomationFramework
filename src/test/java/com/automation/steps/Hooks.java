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
		if (ConfigReader.getProperty("execution.platform").equals("local")) {
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

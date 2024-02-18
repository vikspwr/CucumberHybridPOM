/**
 * 
 */
package com.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utils.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Author : Vikas S Pawar
 */
public class AppHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private PropertiesReader propertiesReader;
	private Properties properties;

	@Before(order = 1)
	public void getMyProperty() {
		propertiesReader = new PropertiesReader();
		properties = propertiesReader.init_Prop();
	}

	@Before(order = 2)
	public void launchBrowser() {
		String browserName = properties.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(browserName);
	}

	@After(order = 1)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@After(order = 2)
	public void getFailedSS(Scenario scenario) {

		if (scenario.isFailed()) {
			String ssName = scenario.getName();
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] ssPath = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(ssPath, "image/png", ssName + " : Test Case Failed!!!");
		}
	}
}

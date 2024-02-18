
package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Author : Vikas S Pawar
 */
public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_Driver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Invalid Browser Selection!!! " + browser + " is not available");
		}
		getMyDriver().manage().window().maximize();
		getMyDriver().manage().deleteAllCookies();
		return getMyDriver();
	}

	public static synchronized WebDriver getMyDriver() {
		return tlDriver.get();
	}
}

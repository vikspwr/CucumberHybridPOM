/**
 * 
 */
package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Author : Vikas S Pawar
 */
public class MyAccountPage {

	private WebDriver driver;

	private By lnk_sign_out = By.xpath("(//a[contains(text(),'Sign out')])[1]");
	private By links = By.xpath("//ul[@class='bullet']/li");

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignOut() {
		driver.findElement(lnk_sign_out).click();
	}

	public int getAllLinksCount() {
		return driver.findElements(links).size();
	}

	public List<String> getAllLinks() {

		List<String> actualLink = new ArrayList<String>();
		List<WebElement> allLinks = driver.findElements(links);
		for (WebElement link : allLinks) {
			String linkName = link.getText();
			actualLink.add(linkName);
		}
		return actualLink;
	}

}

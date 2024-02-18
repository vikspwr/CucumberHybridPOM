package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Author : Vikas S Pawar
 */
public class LoginPage {
	
	private WebDriver driver;
	private By txt_login_email = By.id("email");
	private By txt_login_password = By.id("passwd");
	private By btn_login_signIn = By.id("SubmitLogin");
	private By lnk_login_forgot_password = By.linkText("Forgot your password?");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void enterEmail(String email) {
		driver.findElement(txt_login_email).clear();
		driver.findElement(txt_login_email).sendKeys(email);
	}

	public void enterPassword(String pass) {
		driver.findElement(txt_login_password).clear();
		driver.findElement(txt_login_password).sendKeys(pass);
	}

	public void clickSignIn() {
		driver.findElement(btn_login_signIn).click();
	}

	public boolean isForgotPasswordLinkPresent() {
		return driver.findElement(lnk_login_forgot_password).isDisplayed();
	}
	
	public MyAccountPage loginToApplication(String email,String password) {
		enterEmail(email);
		enterPassword(password);
		clickSignIn();
		return new MyAccountPage(driver);
	}
}

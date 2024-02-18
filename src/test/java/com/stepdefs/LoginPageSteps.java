package com.stepdefs;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.LoginPage;
import com.utils.PropertiesReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Author : Vikas S Pawar
 */
public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getMyDriver());
	private PropertiesReader propertiesReader;
	private Properties properties;

	@Given("User on login page")
	public void user_on_login_page() {
		
		propertiesReader = new PropertiesReader();
		properties = propertiesReader.init_Prop();
		DriverFactory.getMyDriver().get(properties.getProperty("url"));
		
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expTitle) {
		
		String actualTitle = loginPage.getPageTitle();
		
		Assert.assertEquals(expTitle, actualTitle);
	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		boolean isVisible = loginPage.isForgotPasswordLinkPresent();
		Assert.assertTrue(isVisible);
	}

	@When("User enters valid email")
	public void user_enters_valid_email() {

		loginPage.enterEmail(properties.getProperty("email"));
	}

	@When("User enters valid password")
	public void user_enters_valid_password() {
		loginPage.enterPassword(properties.getProperty("password"));
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickSignIn();
	}

	@When("User enters email {string}")
	public void user_enters_email(String email) {
		loginPage.enterEmail(email);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

}

/**
 * 
 */
package com.stepdefs;

import java.util.List;
import java.util.Properties;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;
import com.pages.MyAccountPage;
import com.utils.PropertiesReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Author : Vikas S Pawar
 */
public class MyAccountSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getMyDriver());
	private MyAccountPage accountPage;
	private Properties properties;
	private PropertiesReader propertiesReader;

	@Given("User should be on the My Accounts page")
	public void user_should_be_on_the_my_accounts_page() {
		
		propertiesReader = new PropertiesReader();
		properties = propertiesReader.init_Prop();
		DriverFactory.getMyDriver().get(properties.getProperty("url"));
		loginPage = new LoginPage(DriverFactory.getMyDriver());
		accountPage = loginPage.loginToApplication(properties.getProperty("email"), properties.getProperty("password"));
	}

	@Then("User should see the links on page")
	public void user_should_see_the_links_on_page(DataTable allLinks) {

		List<String> expAllLinks = allLinks.asList();
		List<String> actualLinks = accountPage.getAllLinks();
		System.out.println(accountPage);
		Assert.assertTrue(actualLinks.containsAll(expAllLinks));

	}

	@Then("Link count should be {int}")
	public void link_count_should_be(Integer expTotalLinks) {
		int i = accountPage.getAllLinks().size();
		Integer actualTotalLinks = i;
		Assert.assertEquals(actualTotalLinks, expTotalLinks);
	}

	@When("User click Sign Out link")
	public void user_cliks_sign_out_link() {
		accountPage.clickSignOut();
		
	}
	
	

}

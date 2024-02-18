@all
Feature: My Account Page Features
  To Verify My Account Page Components and Functionality

  Background: Common Steps
    Given User should be on the My Accounts page

	@smoke
	Scenario: Verify My Accounts Page Title
	Then Page title should be "My account - My Shop"

  @regression
  Scenario: Verify My Accounts Page section contains links
    Then User should see the links on page
      | My orders        |
      | My credit slips  |
      | My addresses     |
      | My personal info |
      | Sign out         |
    And Link count should be 5

  @regression
  Scenario: Verify Sign Out Functionality
    When User click Sign Out link
    Then Page title should be "Login - My Shop"

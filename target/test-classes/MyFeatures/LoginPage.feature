@all
Feature: Login Page Features
  To Verify Login Page Components and Functionality

  @smoke
  Scenario: Verify Login Page Title
    Given User on login page
    Then Page title should be "Login - My Shop1"
	
	@smoke
  Scenario: Verify Presence Of Forgot Password Link
    Given User on login page
    Then Forgot password link should be displayed

	@smoke @regression
  Scenario: Verify Login Functionality With Valid Creds
    Given User on login page
    When User enters valid email
    And User enters valid password
    And User clicks on login button
    Then Page title should be "My account - My Shop"

	@smoke @regression
  Scenario Outline: Verify Login Functionality With Invalid Creds
    Given User on login page
    When User enters email "<UserName>"
    And User enters password "<Password>"
    And User clicks on login button
    Then Page title should be "Login - My Shop"

    Examples: 
      | UserName | Password |
      | Admin    | Admin    |
      | User     | User     |

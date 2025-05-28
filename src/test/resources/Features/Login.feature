@OrangeHRM_Login
Feature: OrangeHRM Login Test

  Background:
    Given I am on the HRM login page
  @Valid_Login
  Scenario: Successfully Login with valid credentials
    When I enter the valid username "Admin"
    And I enter the valid password "admin123"
    And I click on the login button
    Then I should be redirected to the OrangeHRM dashboard

    @Invalid_Login
    Scenario: Login attempt with invalid credentials
      When I enter the valid username "Admin"
      And I enter the invalid password "admin12"
      And I click on the login button
      Then The "Invalid credentials" Error message should be displayed
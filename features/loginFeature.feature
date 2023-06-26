Feature: Login Functionality of OrangeHRM website

  As an employee of OrangeHRM company
  I want to be able to login into my account
  So that I can perform my Admin duties

  Scenario: Successful login with valid credentials
    Given I navigated to the login page
    When I enter valid username and password
    And I click the login button
    Then I should be logged in successfully
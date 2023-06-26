Feature: Login Functionality of OrangeHRM website

  As an employee of OrangeHRM company
  I want to be able to login into my account
  So that I can perform my Admin duties

  Scenario: Successful login with valid credentials
    Given I navigated to the login page
    When I enter valid username and password
    And I click the login button
    Then I should be logged in successfully

    Scenario: Unsuccessful login with invalid credentials
      Given I navigated to the login page
      When I enter invalid username and password
      And I click the login button
      Then I should get an error message

      Scenario: Navigating to the forgot password page
        Given I navigated to the login page
        When I click the forgot password link
        Then I should be navigated to the forgot Password page
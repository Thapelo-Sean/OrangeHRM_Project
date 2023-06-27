Feature: Login Functionality of OrangeHRM website

  As an employee of OrangeHRM company
  I want to be able to login into my account
  So that I can perform my Admin duties

  Scenario: Successful login with valid credentials
    Given User navigated to the login page
    When User enters valid username and password
    And User clicks the login button
    Then User should be logged in successfully

    Scenario: Unsuccessful login with invalid credentials
      Given User navigated to the login page
      When User enters invalid username and password
      And User clicks the login button
      Then User should get an error message

      Scenario: Navigating to the forgot password page
        Given User navigated to the login page
        When User clicks the forgot password link
        Then User should be navigated to the forgot Password page

        Scenario: Password reset functionality
          Given User navigated to the login page
          When User clicks the forgot password link
          And User enters valid username
          And User clicks the reset password button
          Then Reset password link should be sent successfully

          Scenario: Check broken links
            Given User navigated to the dashboard page
            When User click any of the navigation links
            Then User should not see a 404 error or broken links

          Scenario: Dashboard Navigation links functionality
            Given User navigated to the dashboard page
            When User clicks any of the navigation links
            Then User should be redirected to the correct page


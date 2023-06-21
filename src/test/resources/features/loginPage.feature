Feature: Login Functionality for OrangeHRM Website

  As a user of the OrangeHRM website
  I want to be able to log in with my account
  So that I can access my account and perform administrative duties

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click the login button
    Then I should be logged in successfully

    Scenario Outline: Unsuccessful login  with invalid or empty credentials
      Given I have entered invalid "<username>" and "<password>"
      When I click on the login button
      Then I should see an error message indicating "<error_message>"

      Examples:
        | username        | password        | error_message                |
        | invalidUsername | invalidPassword | Warning: Invalid credentials |
        | Admin           | Admin1123       | Warning: Invalid credentials |

  Scenario: Navigating to the forgot password page
    When I click on the forgot your password? link
    Then I should be redirected to the password reset page

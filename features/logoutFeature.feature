Scenario: Logout Functionality
Given User navigated to the login page
When User enters valid username and password
And User clicks the login button
And User clicks the user dropdown name
And User clicks the logout link
Then User should logged out successfully
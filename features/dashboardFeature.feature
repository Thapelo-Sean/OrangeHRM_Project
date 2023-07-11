Feature: Dashboard Functionality of OrangeHRM website

Scenario: Verify broken links
Given User navigated to the dashboard page
When User clicks any of the navigation links
Then User should not see a 404 error or broken links

Scenario: Dashboard Navigation links functionality
Given User navigated to the dashboard page
When User clicks any of the navigation links
Then User should be redirected to the correct page
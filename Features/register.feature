Feature: User Registration

  Scenario: Successful new user registration
    Given User is on the nopCommerce registration page URl "https://demo.nopcommerce.com/register"
    When User enters first name, last name, email, password, and confirm password
    And User clicks the register button
    Then User should see the registration confirmation message "Your registration completed"

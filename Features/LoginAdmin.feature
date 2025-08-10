Feature: LoginAdmin

Scenario: Successful Login with Valid Credentials
        Given User launch chrome browser
        When User opens Url "https://admin-demo.nopcommerce.com/login"
        And User enters Emails as "admin@yourstore.com" and Password as "admin"
        And Click on login 
        Then Page Title should be "Dashboard / nopCommerce administration"
        When User click on Logout link
        Then Page Title should be "nopCommerce demo store. Login"
        And close browser
        
Scenario Outline: Login with Data Driven
        Given User launch chrome browser
        When User opens Url "https://admin-demo.nopcommerce.com/login"
        And User enters Emails as "<email>" and Password as "<pwd>"
        And Click on login 
        Then Page Title should be "Dashboard / nopCommerce administration"
        When User click on Logout link
        Then Page Title after logout should be "nopCommerce demo store. Login"
        And close browser        
        
        Examples:
        |email|pwd|
        |admin@yourstore.com|admin|
        |admin1@yourstore.com|admin|
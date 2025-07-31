Feature: Customers

Scenario: Add a new Customer
    Given User launch chrome browser
        When User opens Url "https://admin-demo.nopcommerce.com/login"
        And User enters Emails as "admin@yourstore.com" and Password as "admin"
        And Click on login 
        Then User can view Dashboard
        When User click on customers Menu
        And click on customers Menu Item
        And click on Add new button
        Then User enter customer info
        And click on Save button
        Then User can view confirmation message "The new customer has been added successfully."
        And close browser
     

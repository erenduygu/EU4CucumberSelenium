Feature: Login as different users
  @smoke
  Scenario: login as a driver user
    Given the user is on the login page
    When the user logs in using "User10" and "UserUser123"
    Then the user should be able to login
    And the title contains "Dashboard"

        #homework
  Scenario: login as a driver
    Given the user is on the login page
    Given the user logged in as "sales_manager"
    Then the user should be able to login
    And the title contains "Dashboard"
    #driver,storemanager,salesmanager
   #you will have one step definition and it will handle differnet usertypes
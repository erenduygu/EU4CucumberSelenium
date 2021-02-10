Feature: Account Types


  Scenario:  Driver user
    Given the user logged in as "driver"
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"

  @wip
  Scenario:  Sales Manager user
    Given the user logged in as "sales manager"
    When the user navigates to "Customer" "Accounts"
    Then the title contains "All - Accounts - Customers"


  Scenario:  Store Manager user
    Given the user logged in as "store manager"
    When the user navigates to "Customers" "Contacts"
    Then the title contains "Contacts - Customers"


    # Scenario:  Driver user
    # Given the user logged in as "driver"

    # Scenario:  Sales Manager user
    # Given the user logged in as "sales manager"

    # Scenario:  Store Manager user
    # Given the user logged in as "store manager"


  Scenario Outline:  Different user types
    Given the user logged in as "<userType>"

    Examples:

      | userType      |
      | driver        |
      | sales manager |
      | store manager |
      | admin         |



  Scenario Outline: Login with different accounts

    Given the user logged in as "<userType>"
    When the user navigates to "<tab>" "<module>"
    Then the title contains "<title>"

    Examples:
      | userType      | tab        | module          | title                        |
      | driver        | Activities | Calendar Events | Calendar Events - Activities |
      | sales manager | Customers  | Accounts        | Accounts - Customers         |
      | store manager | Customers  | Contacts        | Contacts - Customers         |

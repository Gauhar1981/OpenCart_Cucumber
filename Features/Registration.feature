Feature: Account Registration

  @Regression
  Scenario: Successful Account Registration
    Given the user navigates to Register Account page
    When the user enters the details into below fields
      | firstName | John           |
      | lastName  | Kenedy         |
      | email     | test1@test.com |
      | password  | test@123       |
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully
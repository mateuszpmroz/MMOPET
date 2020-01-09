Feature: Deletes champion

  Scenario: Deletes champion from db
    Given I am admin user
    When I deletes champion
    Then It should not longer appear in the list
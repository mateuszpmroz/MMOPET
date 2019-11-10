Feature: Add another champion to a friend

  Scenario: Search for a friend not typing full name and adds him to friend list
    Given I am logged as a champion
    And I don't have a friend on a friend list
    When I search for a "es" on add friend list search box and add as a friend
    Then I should have a new friend on a friend list
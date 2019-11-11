Feature: Add another champion to a friend

  Scenario: Search for a friend not typing full name and adds him to friends list
    Given I am logged as a champion
    And I don't have a friend on a friends list
    When I search for a "es" on add friends list search box
    And I add champion as a friend
    Then I should have a new friend on a friends list

  Scenario: Search and adds for a friend which exist already on friends list
    Given I am logged as a champion
    And I have a friend on a friends list
    When I search for a "es" on add friends list search box
    Then I should got an error when add existing friend as a friend

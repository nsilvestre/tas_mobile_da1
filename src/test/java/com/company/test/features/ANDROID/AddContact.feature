Feature: Add new contact

  @working
  Scenario Outline: Create contact
    Given <config> appium driver

    When I tap Add button
    And I enter the first name and last name
    And I enter the phone number
    And I tap save
    Then I close app

    Examples:
      | config           |
      | android_emulator_Nexus6API27 |

  @working
  Scenario Outline: Delete contact
    Given <config> appium driver

    When I select the contact
    And I tap the menu
    And I tap delete
    And I tap delete from the alert
    Then I close app

    Examples:
      | config           |
      | android_emulator_Nexus6API27 |
Feature: Testing for the Saucedemo application

#  @MaximumValueSelectionScenario #tags
#  Scenario Outline: Selecting the Maximum price
#    Given User should login with the url
#    When the user enters the "<username>" and "<password>"
#    Then Click on the login button
#    And check the url matches with the expected one
#    Then To get the maximum price from the listed price
#    And Validation of the button using assertion
#    Examples:
#      | username      | password     |
#      | standard_user | secret_sauce |

  @MaximumValueSelectionScenario #tags
  Scenario: Selecting the Minimum price
    Given User should login with the url
    When the user enters the username and password
    Then Click on the login button
    And check the url matches with the expected one
    Then To get the Maximum price from the listed price
    And Validation of the button using assertion


  @MinimumValueSelectionScenario #tags
  Scenario: Selecting the Minimum price
    Given User should login with the url
    When the user enters the username and password
    Then Click on the login button
    And check the url matches with the expected one
    Then To get the Minimum price from the listed price
    And Validation of the button using assertion
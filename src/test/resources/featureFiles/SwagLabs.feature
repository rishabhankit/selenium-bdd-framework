Feature: SwagLabs Login

  @ankit
  Scenario Outline: Login to Swag Labs
    When I Enter "<Username>" and "<Password>"
    And I click on login button
    Then I verify SwagLabs home page
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |





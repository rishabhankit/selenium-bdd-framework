Feature: February Login

  @ankit
  Scenario: PNR label
    When I fetch PNR label
    When I fetch Charts label


    Scenario:Charts label
      When I fetch Charts label
      When I fetch PNR label


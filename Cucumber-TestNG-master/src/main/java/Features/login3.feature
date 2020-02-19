@Test3
Feature: Innovaccer ShopData Login Feature - 3

  Scenario Outline: ShopData Login Test Scenario - 3
    Given Env Setup and User is already on Home Page
    Then Validating Title and login application with username "<username>" and password as "<password>"

    Examples: 
      | username            | password |
      | care@innovaccer.com | demo123  |

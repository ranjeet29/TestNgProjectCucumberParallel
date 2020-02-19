@Test2
Feature: Innovaccer ShopData Login Feature - 2

  Scenario Outline: ShopData Login Test Scenario - 2
    Given Env Setup and User is already on Home Page
    Then Validating Title and login application with username "<username>" and password as "<password>"

    Examples: 
      | username            | password |
      | care@innovaccer.com | demo123  |

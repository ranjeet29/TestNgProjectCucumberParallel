@TestFeature-1
Feature: Innovaccer ShopData Login Feature - 1

  @Test1
  Scenario Outline: ShopData Login Test Scenario - 1
    Given Env Setup and User is already on Home Page
    Then Validating Title and login application with username "<username>" and password as "<password>"

    Examples: 
      | username            | password |
      | care@innovaccer.com | demo123  |

      
  @Test2
  Scenario Outline: ShopData Login Test Scenario - 2
    Given Env Setup and User is already on Home Page
    Then Validating Title and login application with username "<username>" and password as "<password>"

    Examples: 
      | username            | password |
      | care@innovaccer.com | demo123  |
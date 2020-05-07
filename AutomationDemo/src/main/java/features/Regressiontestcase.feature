Feature: Regression Test

Background: Login user

Given user enters <username> and <password>
      | admin@yourstore.com | admin |


  @RegressionTest7
  Scenario Outline: create user profile and login
    Given application is launched
    Then create profile using testdata "<Testdata>"
    And verify login "<Testdata>"

    Examples: 
      | Testdata |
      | TC01     |
      

      @RegressionTest
  Scenario: Login Test Scenario
  #  Given user enters <username> and <password>
   #   | admin@yourstore.com | admin |
    Then verify the  user is on home page


  @RegressionTest1
  Scenario: Search Product
    #Given user enters <username> and <password>
     # | admin@yourstore.com | admin |
    And verify the  user is on home page
    Then search the Dashboard<dashboard> with product <product> and <value>
      | Catalog | Products | $100 Physical Gift Card |
      
    And veriy product is dispalyed
      | $100 Physical Gift Card |
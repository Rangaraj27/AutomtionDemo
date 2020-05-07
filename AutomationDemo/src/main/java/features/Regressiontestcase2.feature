Feature: Regression Test1


  @RegressionTest1
  Scenario: Search Product
    #Given user enters <username> and <password>
     # | admin@yourstore.com | admin |
    And verify the  user is on home page
    Then search the Dashboard<dashboard> with product <product> and <value>
      | Catalog | Products | $100 Physical Gift Card |
      
    And veriy product is dispalyed
      | $100 Physical Gift Card |
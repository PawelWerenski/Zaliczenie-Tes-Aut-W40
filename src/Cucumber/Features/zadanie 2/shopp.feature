Feature: Shopping on user account

  Scenario: user has an active account
    Given login in shop page
    And I login using "mhgwrsdzokmeyjvcha@cazlp.com" and "haslo"
    And I go to the clothes window
    Then I choose proper product
    And I choose the size "M", quantity "5" and add products to the basket
    And I go to basket to proceeded to checkout
    When I confirm address, shipping method, payment and place order
    Then I take a screenshot with order confirmation message, amount
    And I go to orders history and details
    And I verify whether the order has "Awaiting check payment" status
    And I close this page
Feature: Add a new user's address after login


  Scenario Outline: Add a new address in the info field
    Given I'm on the shop authentication page
    When I login using "mhgwrsdzokmeyjvcha@cazlp.com" and "Password123"
    And I go to my addresses page
    And I attempt to add a new address
    And I enter new address <alias>, "<address>", "<city>", <postcode>, <phone>
    Then I can see a new address
    And I verify created address has <alias>, "<address>", "<city>", <postcode>, <phone>
    And I close the browser
    Examples:
      | alias | address | city | postcode | phone |
      | Home | Groove str.| New York | 50-555 | +112293344 |

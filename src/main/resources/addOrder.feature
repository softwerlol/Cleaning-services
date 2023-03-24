Feature: Add Order to a Cleaning Order system
  Description: Add an Order to the Cleaning Order system
  Actors: Customer

  Scenario Outline: Add an order successfully
    Given the customer is logged in
    Given he/she choose day <Day>
    And he/she choose month <Month>
    Given he/she choose year <Year>
    And he/she choose time <Time>
    Then this Order will book for this customer
    Examples:
      |Day|Month|Year|Time|
      |"05"|"07"|"2023"|"2"|
      |"12"|"10"|"2023"|"9"|


  Scenario Outline: Add an order unsuccessfully
    Given the customer is logged in
    Given he/she choose day <Day>
    And he/she choose month <Month>
    Given he/she choose year <Year>
    And he/she choose time <Time>
    Then the error message "This order was reserved by another customer" will appear
    Examples:
      |Day|Month|Year|Time|
      |"05"|"01"|"2023"|"11"|
      |"14"|"05"|"2023"|"3"|

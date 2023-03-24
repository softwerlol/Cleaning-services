Feature: Users Sign in
  Description: The Users signs into Cleaning Management System
  Actor: All Users

  Background:
    Given the user on the login page
    When the user enter one of the following user name and password regardless his role
      |Ahmad     |ahmad123   |Admin |
      |Qasem     |qasem123   |Worker|
      |Anas      |anas123     |Customer|
      |Sara      |sara123      |Secretary|

  Scenario Outline: the <role> enter valid credentials
    Given That the <role> is not signed in
    And the <role> username is <username>
    And the <role> password is <password>
    Then the <role> sign in succeeds
    And the <role> is signed in
    Then go to <role> page
    Examples:
      |username    |password     |role|
      |"Ahmad"     |"ahmad123"   |"Admin" |
      |"Qasem"     |"qasem123"   |"Worker"|
      |"Anas"      |"anas123"    |"Customer"|
      |"Sara"      |"sara123"    |"Secretary"|


  Scenario Outline: the <role> enter invalid credentials
    Given That the <role> is not signed in
    And the <role> username is <username>
    And the <role> password is <password>
    Then the <role> sign in not succeeds
    And the <role> is not signed in

    Examples:
      |username    |password      |role|
      |"Ahmad"     |"ahmad123"   |"Admin" |
      |"Qasem"     |"qasem123"   |"Worker"|
      |"Anas"      |"anas123"    |"Customer"|
      |"Sara"      |"sara123"    |"Secretary"|

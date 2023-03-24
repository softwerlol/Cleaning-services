Feature: Users Sign Out
  Description: The Users signed out of the Cleaning Management System
  Actor: All Users

  Background:
    Given the users credentials

      |Ahmad     |ahmad123   |Admin |
      |Qasem     |qasem123   |Worker|
      |Anas      |anas123     |Customer|
      |Sara      |sara123      |Secretary|

  Scenario Outline: the <role> signed out
    Given that the <role> is signed in
    When the <role> signs out
    Then the <role> is not signed in

    Examples:
      |username   |password   |role|
      |"Ahmad"     |"ahmad123"   |"Admin" |
      |"Qasem"     |"qasem123"   |"Worker"|
      |"Anas"      |"anas123"    |"Customer"|
      |"Sara"      |"sara123"    |"Secretary"|


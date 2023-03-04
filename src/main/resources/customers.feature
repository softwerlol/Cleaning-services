Feature: customers feature
  I want to use this template for my feature file

  Background: The system has a set of customers
    Given that those customers are registered in the system
      | c00001 | ahmad@00001 |1000|ahmadST |Nablus|ahmad@yahoo.com |0569911122|false |
      | c00002 | qasem@00002|1055|qasemST|jenen |qasem@yahoo.com|0596688899|false |
      | b12345 | mohamad@00003 |1005|mohamadST|Nablus|mohamad@yahoo.com|0567799922|false |
      | c00005 | anas@00003 |1005|anasST|Nablus|anas@yahoo.com|0567799922|false |

  Scenario: customers sign up with valid username
    Given   patient enter username "c12345"
    When    save customers username "c12345" validation
    Then    customers username is valid

  Scenario: customers sign up with invalid username
    Given   customers enter username "2345"
    When    save customers username "2345" validation
    Then    customers username is invalid


  Scenario: customers sign up with valid password
    Given   customers enter password "Aahmad@1234"
    When    save patient password "Aahmad@1234" validation
    Then    customers password is valid

  Scenario: customers sign up with invalid password
    Given   customers enter password "aahmad@1234"
    When    save customers password "Aahmad@1234" validation
    Then    customers password is invalid

  Scenario: customers valid email
    Given   customers enter email "Aahmad@yahoo.com"
    When    customers email get "Aahmad@yahoo.com" checked
    Then    customers valid email

  Scenario: customers valid email
    Given   customers enter email "Aahmad.yahoo.com"
    When    customers email get "Aahmad.yahoo.com" checked
    Then    customers invalid email

  Scenario: customers validation mobile number
    Given   customers enter mobile number "0562233341"
    When    customers mobile number get "0562233341" checked
    Then    valid mobile number

  Scenario: customers validation mobile number
    Given   customers enter mobile number "0572233341"
    When    customers mobile number get "0562233341" checked
    Then    invalid mobile number

  Scenario: customers validation Address
    Given  customers enter address: apartmentNumber "1000", streetName "ahmadST" , city "Nablus"
    When   customers : apartmentNumber "1000", streetName "ahmadST" , city "Nablus" get checked
    Then   valid Address

  Scenario: customers validation Address
    Given  customers enter address: apartmentNumber "w1000", streetName "2ahmadST" , city "Nablus"
    When   customers : apartmentNumber "w1000", streetName "2ahmadST" , city "Nablus" get checked
    Then   invalid Address

  Scenario: customers sign in successful
    Given     customers is sign in by username "c00001"
    Then      customers is sign in

  Scenario: customers sign in failed
    Given     customers is sign in by username "r12345"
    Then      customers is not sign in

  Scenario: customers online customers
    Given     print online array list
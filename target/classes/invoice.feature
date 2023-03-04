Feature: Invoice
  I want to use this template for my feature file



  Background: The system has a set of invoices
    Given that those invoices are  in the system class invoice
      |1	|c00001	| d12345  | carpets     |  40	 |
      |2	|c00002	| d12345  |covers  |  10  |
      |3	|c00005 | d12340  |carpets and covers  |  1000|


  Scenario: customers has request invoice
    Given invoice number 1 customers name "c00001" Worker name "p12345" service "carpets" fee "40"
    Then  requested invoice and print it
   #Background: The system has a set of customers and appointments
#	Given that those customers and appointments are in the system to print report hi
  #|		|		    | 2022        |1       |   15    |
  #|1	|c00001	| 08:00       |08:30   |  true	 |d12345  | carpets     |  40	 |
  #|2	|c00001	| 08:30       |09:00   |  true   |d12345  | covers  |  10  |
  #|3	|c00002	| 09:00       |09:30   |  true   |d12340  |carpets and covers  |  1000|


  #Scenario: System Print invoice report
 #	Given  report printed
#	Then   report generated

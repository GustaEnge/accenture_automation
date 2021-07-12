#language:en
Feature: Buying a vehicle insurance in Tricentis webpage
  I enter some vehicle data and send a quote
  
  Background:
  	Given I have to access Tricentis

  
  Scenario Outline: Buying a vehicle insurance
    Given I have to be on Enter Vehicle Data tab for vehicle
    | make | model  | cc     |kW          |dateManu     |seats  |hand  |numSeats  |fuel  |payload  |weight  |price  |plateNumber  |mileage  |
    |<make>| <model>| <cycap>|<enginePerf>|<dateManufac>|<seats>|<hand>|<numSeats>|<fuel>|<payload>|<weight>|<price>|<plateNumber>|<mileage>|
    And I need to Enter Insurant Data tab for insurant
    | name | lname     | birth      |gender  |street  |country  |zip      |city  |occupation  | hobbies  |website  |picture  |
    |<name>| <lastName>| <birthDate>|<gender>|<street>|<country>|<zipCode>|<city>|<occup>     |<hobbies> |<website>|<picture>|
    And I need to Enter Product Data tab for product
    | start     | insuranceSum     | meritRating      |damageIns        |optionals     |courtesy  |
    |<startDate>| <insuranceSum>   | <meritRating>    |<damageInsurance>|<optionalProd>|<courtesy> |
    And I Select Price Option : <priceOption>
    Then I Send Quote using the following data: <email>, <phone>, <user>, <pwd> and <comments>
    
    Examples: 
		|email                   | phone            | user          | pwd       | comments | priceOption | make | model   | cycap | enginePerf | dateManufac | seats | hand | numSeats | fuel | payload | weight | price | plateNumber | mileage | name     | lastName | birthDate  | gender | street               | country | zipCode | city        | occup           | hobbies        | website                                        | picture                               | startDate  | insuranceSum  | meritRating | damageInsurance | optionalProd    | courtesy |
		|cunha.goc@gmail.com     | 5517982823713    | goc.cunha     | A1e2189   | -        | gold        | Audi | Scooter | 500   | 500        | 12/01/1998  | 9     | yes  | 3        | Gas  | 30      | 200    | 2000  | ATE516712   | 250     | Gustavo  | Cunha    | 06/18/1994 | Male   | 43 Paulo Afonso      | Brazil  |15115000 | Ibirá       | Employee        | Speeding       | https://www.linkedin.com/in/gustavo-cunha-md/  | C:\Users\ovatu\Pictures\arvore_1.jpg  | 09/01/2021 | 3000000       | Bonus 1     | No Coverage     | Euro Protection | Yes      |
		|amanda.goc@gmail.com    | 5517982823713    | goc.amanda    | 3Bt2189   | -        | silver      | Audi | Scooter | 500   | 500        | 12/01/1998  | 9     | yes  | 3        | Gas  | 30      | 200    | 2000  | ATE516712   | 250     | Amanda   | Cunha    | 06/18/1994 | Female | 43 Paulo Afonso      | Brazil  |15115000 | Ibirá       | Public Official | Bungee Jumping | https://www.linkedin.com/in/gustavo-cunha-md/ | C:\Users\ovatu\Pictures\arvore_1.jpg  | 09/05/2021 | 3000000       | Bonus 1     | No Coverage     | Euro Protection | Yes      |
      

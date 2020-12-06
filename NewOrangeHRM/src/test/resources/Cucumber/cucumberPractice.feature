Feature:This file is to practice cucumber.
             Cucumber Practice
             
Scenario: we are going to multiply given number.

Given  i assign first value 
And i assign   second value
When    i multiply
Then i see the total  

Scenario: Second attempt

Given  i assign first value 
And i assign   second value
When    i multiply
Then i see the total

Scenario Outline: multiply multiple numbers   

Given I assign first <value>
    When I assign second <value2> 
    Then then I recive 
    
    Examples: 
      | value | value2  |
      |    10 | 	15 	  |
      |    20 |    7    |
      |    30 | 	15 	  |
      |    40 |    7    |
## DMoney -API-Automation with Rest Assured
This project contains simple API automation of Dmoney API. D-Money is a demo financial related project where fake transaction can be transferred.
In this project, I have automated few API's using Rest Assured.
Here, I have completed few tasks - these are -
  - Login using admin credentials,
  -  Create User,
  -  Depost money ,
  -   Send money,
  -   money Withdraw,
  -   Payment and Check Balance after completing above tasks.

### Tools and Technology Used
  - Java
  - IntelliJ IDEA
  - Rest Assured
  - Jackson Databind
  - TestNG Framework
  - Allure

### Prerequisites
  - JDK
  - Gradle

### How to run this project
  - Clone this project ``` https://github.com/Katha-Sikdar/Dmoney-RestAssured```
  - Open terminal
  - Give the following command: gradle clean test
  - For generating Allure Report use these commands:
       -  allure generate allure-results --clean -output
       -  allure serve allure-results


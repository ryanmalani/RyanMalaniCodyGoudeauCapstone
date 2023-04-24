# Undergrad Capstone Assessment: Game Store Project

## Challenge: Game Store Project

For their capstone project, students apply the full extent of the skills they’ve learned in the bootcamp to deploy a final project, working independently or in groups to take a concept from specification to deployment.

This project involves creating a simple database backed REST inventory management web service for a Video Game Store using Agile development techniques in a solo setting. You are responsible for designing and documenting the REST API and implementing the controller, service layer, DAO, Java data objects, and unit tests for the application based on an existing database structure.

In addition, you will produce a 1-3 minute video summary of the project.

Students will also be able to add their project and capstone to their own Github portfolios. The skills covered within this course will help them as they prepare for interviews and internships! 


## Structure

Your solution must have the following structural elements:
- Your solution must be in an IntelliJ project called FirstNameLastNameCapstone where FirstName and LastName are your first and last names respectively.
- Your project must be built using Spring Boot and Spring MVC. Initialize your project using start.spring.io
- Your solution must include a DAO that utilizes JdbcTemplates and Prepared Statements
- Your REST API must be documented with Swagger
- Your REST API must accept and return data in JSON format where appropriate
- You must implement ControllerAdvice to handle exceptions and return proper HTTP status codes and data when exceptions occur. This includes handling all violations of business rules.



## Methodology

- You must manage your work in Pivotal Tracker
- You must create stories and epics
- You must estimate your work using story points
- You must use a Test Driven Development approach (including Red/Green/Refactor) for your code
- You must use JUnit for unit and integration tests
- Your design must include a Service Layer
- Your unit test suite should utilize mock objects where appropriate
- You should utilize JSR303 for input validation



## Requirements/Features

This system must manage the inventory of video games, game consoles, and t-shirts.
Your REST API must allow the end user to:
1. Games:
    - Perform standard CRUD operations for Games
    - Search for Games by Studio
    - Search for Games by ESRB Rating
    - Search for Games by Title
    - You must create a separate DAO for Games
2. Consoles:
    - Perform standard CRUD operations for Consoles
    - Search for Consoles by Manufacturer
    - You must create a separate DAO for Consoles
3. T-Shirts:
    - Perform standard CRUD operations for T-Shirts
    - Search for T-Shirts by Color
    - Search for T-Shirts by Size
    - You must create a separate DAO for T-Shirts
4. Purchasing Items (Invoice Creation):
    - User should be able to purchase items in inventory by supplying the following information to the endpoint:
        - Name
        - Street
        - City
        - State
        - Zip
        - Item Type
        - Item ID
        - Quantity
    - The endpoint returns invoice data based on the invoice table below.
    - All invoice calculations must be done in the Service Layer.
    - You must create a DAO for both taxes and processing fees.
    
    
- You must use the following database structure:

   ```sql
    create schema if not exists game_store;
    use game_store;
    
    create table if not exists game (
        game_id int(11) not null auto_increment primary key,
        title varchar(50) not null,
        esrb_rating varchar(50) not null,
        description varchar(255) not null,
        price decimal(5, 2) not null,
        studio varchar(50) not null,
        quantity int(11)
    );
    
    create table if not exists console (
        console_id int(11) not null auto_increment primary key,
        model varchar(50) not null,
        manufacturer varchar(50) not null,
        memory_amount varchar(20),
        processor varchar(20),
        price decimal(5, 2) not null,
        quantity int(11) not null
    );
    
    create table if not exists t_shirt (
        t_shirt_id int(11) not null auto_increment primary key,
        size varchar(20) not null,
        color varchar(20) not null,
        description varchar(255) not null,
        price decimal(5,2) not null,
        quantity int(11) not null
    );
    
    create table if not exists sales_tax_rate (
        state char(2) not null,
        rate decimal(3,2) not null
    );
    
    create unique index ix_state_rate on sales_tax_rate (state, rate);
    
    create table if not exists processing_fee (
        product_type varchar(20) not null,
        fee decimal (4,2)
    );
    
    create unique index ix_product_type_fee on processing_fee (product_type, fee);
    
    create table if not exists invoice (
        invoice_id int(11) not null auto_increment primary key,
        name varchar(80) not null,
        street varchar(30) not null,
        city varchar(30) not null,
        state varchar(30) not null,
        zipcode varchar(5) not null,
        item_type varchar(20) not null,
        item_id int(11) not null,
        unit_price decimal(5,2) not null,
        quantity int(11) not null,
        subtotal decimal(11,2) not null,
        tax decimal(5,2) not null,
        processing_fee decimal (5,2) not null,
        total decimal(11,2) not null
    );

   ```
  
## Test Requirements
- You must test all routes using MockMVC.
- This includes testing for both expected return values, and expected controller failures (4xx and 5xx status codes)
- Test all service layer methods
- You should have 100% code coverage of the service layer
- These should be unit tests—in other words, they should employ mocking
- You must have integration tests for all DAOs
- These should test the basic CRUD operations
- It should also test any custom methods you've defined (such as findByCategory)


## Business Rules
1. Sales tax applies only to the cost of the items.
2. Sales tax does not apply to any processing fees for an invoice.
3. The processing fee is applied only once per order regardless of the number of items in the order unless the number of items on the order is greater than 10 in which case an additional processing fee of $15.49 is applied to the order.
4. The order process logic must properly update the quantity on hand for the item in the order.
5. Order quantity must be greater than zero.
6. Order quantity must be less than or equal to the number of items on hand in inventory.
7. Order must contain a valid state code.
8. The REST API must properly handle and report all violations of business rules.


## Data

#### Tax Rates
Load the following tax rates into your database:
- Alabama —AL: .05
- Alaska—AK: .06
- Arizona—AZ: .04
- Arkansas—AR: .06
- California—CA: .06
- Colorado—CO: .04
- Connecticut—CT: .03
- Delaware—DE: .05
- Florida—FL: .06
- Georgia—GA: .07
- Hawaii—HI: .05
- Idaho—ID: .03
- Illinois—IL: .05
- Indiana—IN: .05
- Iowa—IA: .04
- Kansas—KS: .06
- Kentucky—KY: .04
- Louisiana—LA: .05
- Maine—ME: .03
- Maryland—MD: .07
- Massachusetts—MA: .05
- Michigan—MI: .06
- Minnesota—MN: .06
- Mississippi—MS: .05
- Missouri—MO: .05
- Montana—MT: .03
- Nebraska—NE: .04
- Nevada—NV: .04
- New Hampshire—NH: .06
- New Jersey—NJ: .05
- New Mexico—NM: .05
- New York—NY: .06
- North Carolina—NC: .05
- North Dakota—ND: .05
- Ohio —OH: .04
- Oklahoma—OK: .04
- Oregon—OR: .07
- Pennsylvania—PA: .06
- Rhode Island—RI: .06
- South Carolina—SC: .06
- South Dakota—SD: .06
- Tennessee—TN: .05
- Texas—TX: .03
- Utah—UT: .04
- Vermont—VT: .07
- Virginia—VA: .06
- Washington—WA: .05
- West Virginia—WV: .05
- Wisconsin—WI: .03
- Wyoming—WY: .04


#### Processing Fees
Load the following processing fees into your database:
- Consoles: 14.99
- T-Shirts: 1.98
- Games: 1.49


## Video Summary Requirement

- Create a 1-3 minute video summary highlighting your project. Be sure to highlight the sections of the project that are important
in meeting the project requirements. Be sure to provide the following video requirements:
    * Video should be created in MP4 format.
    * Video should include a screen capture recording to display the important sections of the project.


## Submission

Once you have completed your assessment, it’s time to submit. Follow the steps from your first summative submission, but customize the naming conventions for this particular assignment. Also, remember to submit your video summary. Make sure to double check that your submission is completed.

## Grading Requirements

In this challenge, your grade will consist of a combination of general setup and format requirements and your actual code. See the criteria below for more detailed information:


### **General set up and format requirements:**

- Solution must be in an IntelliJ project called FirstNameLastNameCapstone.
- Project must be built using Spring Boot and Spring MVC. Initialize your project using start.spring.io.
- Project must use JDBCTemplates that follows the pattern shown in previous modules.
- Project comes with a full set of test cases.
- Project implements basic SQL queries to communicate with the DB.

### **Game Entity Code:**
- Code is clean (follows general patterns as presented in class).

- Implementation of DAO for:
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Studio
    - By ESRB
    - By Title
  
- Test of DAO for:
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Studio
    - By ESRB
    - By Title
  
- REST API endpoints and OpenAPI Documentation
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Studio
    - By ESRB
    - By Title


### **T-Shirt Entity Code:**

- Code is clean (follows general patterns as presented in class)

- Implementation of DAO for:
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Color
    - By Size
  
- Test of DAO for:
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Color
    - By Size
  
- REST API endpoints and OpenAPI Documentation
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Color
    - By Size


### **Console Entity Code:**

- Code is clean (follows general patterns as presented in class)

- Implementation of DAO for:
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Manufacturer
  
- Test of DAO for:
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Manufacturer
  
- REST API endpoints and OpenAPI Documentation
    - Create
    - Read
    - Read All
    - Update
    - Delete
    - By Manufacturer
    
### **Controller Advice and Validation Code:**

- Code is clean (follows general patterns as presented in class)

- JSR 303 validations match database constraints and messages are clear and concise

- 3 of 3 Present
    - Implementation utilizes the ResponseEntity pattern presented in class 
    - Controller Advice returns 422 status code where appropriate
    - Controller Advice handles all possible exceptions thrown by Controller, DAO, and Service Layer (if present) code 

---

© 2021 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
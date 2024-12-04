
Reward-point-calculator. This project calculates the reward points for single and multiple customers based on the customer transaction.

This project calculates the reward points for single and multiple customers based on the customer transaction amount.

If the customer does the transaction is greater than 100$, then the reward point is 2 for each dollar the customer spent. 
The reward point is 1 for the transaction amount between the range 50-100$.
There is no reward point for a transaction less than $50$. Here, the DB is used to store and calculate the total reward points, monthly summation of reward points, and 3-month reward point summation. 
Here I used MySQL db.

The tables to be created in MySQL DB are 
   1. Customer 
   2. Transaction
      
The relationship between the customer and the Transaction is One-To-many. Here Customer ID is used as a foreign key in the Transaction table.
Whenever a new transaction is made, the reward point is calculated and stored in the database along  with the customer transaction data.

Project-setup :

    Install the required software. (MySQL DB is used here).
    
    Clone/download  the project src code from Git Hub.
    
    Import the maven project into Eclipse
    
    Run  the CLEAN and Install maven commands.
DB setup : 

To store the 3-month customer transaction data, Here I used MYSQL DB.
By default, it should create the db and tables in MYSQL.In case the schema and tables are not created run the following MySQL commands to create schema and Tables.

CREATE DATABASE IF NOT EXISTS rewardpointdb; 

use rewardpointdb;

CREATE TABLE `Customer` (
  `Customer_ID` int AUTO_INCREMENT,
  `Customer_Name` varchar(100) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `EmailID` varchar(100) DEFAULT NULL, 
  `phone` varchar(25) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Customer_ID`)
); 

CREATE TABLE `Transaction` (
  `Trans_Id` int AUTO_INCREMENT,
  `Trans_Date` date DEFAULT NULL,
  `Trans_Amt` int DEFAULT NULL,
  `Reward_Points` int DEFAULT NULL, 
  `customer_Id` INT DEFAULT NULL,  
  PRIMARY KEY (`Trans_Id`),
  FOREIGN KEY (customer_Id) REFERENCES Customer(customer_Id)
);

Run the RewardpointDemo3Application.java to start the spring-boot-application 


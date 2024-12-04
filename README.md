1. Project's Title
Reward-point-calculator. This project calculate the reward points for a single and multiple customer based on the customer transaction.
2. Project Description
This project calculates the reward points for a single and multiple customers based on the customer transaction amount.
If the customer does the transaction amount is greater than 100$, then the reward point is 2 for each dollor. The reward point is 1 for the transaction amount between the range 50-100$.There is no, reward point for the transaction lesser than 50$.
3.Here, to calculate the total reward points , monthly summation of reward points, 3 month reward point summation the DB is used.Here I used MySQL db.
The tables to be created in MySQL DB are 
1.Customer 2.Transaction
The relationship between the customer and Transaction is One-To-many.Here Customer Id is used as a foreign key in Transaction table.
Whenever the transaction is created, the reward point calculation is done and it is also stored in the db.
Project-setup : 
Install the required softwares.(MySQL DB is used here)
Clone/download  the project src code from github.
Import the maven project into eclipse and
 Run  the CLEAN and Install maven commands.
DB setup : 
In order to store the 3 month customer transaction data, Here I used MYSQL DB.
By default it should create the db and tables in MYSQL.In case the schema and tables are not created run the following MySQL commands to create schema and Tables.
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



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

Technology Used : 

- Spring Boot  
- MySQL  
- Java 17  
- Maven  
- JUnit

  
URL:  http://localhost:8080/customer

Method: POST

To create Customer data and store it in MySQL DB

Input JSON to test in Postman

		{
		"customerName":"Customer1",
		"address" :"Address1",
		"emailID":"email@gmail1.com",
		"phone":134567928
		}

Url: http://localhost:8080/customer/{customerId}/transactions

Method: GET

To get the customer with a transaction List for the given customer ID

URL: http://localhost:8080/customer/{customerId}/rewardpointsum

Method: GET

To get the customer details with transaction List and total reward points, the sum of 3-month reward points, and  month-wise reward point report for the given customer ID


{
    "customerId": 1,
    "customerName": "Customer1",
    "address": "Address1",
    "emailID": "email@gmail.com",
    "phone": 123456789,
    "created_at": "2024-11-27",
    "created_by": "Customer1",
    "updated_at": null,
    "updated_by": null,
    "transList": [
	{
	"transId": 1,
	"transDate": "2024-11-27",
	"transAmt": 120,
	"rewardpoints": 90,
	 "customerId": 1
	},
        {
            "transId": 2,
            "transDate": "2024-11-27",
            "transAmt": 150,
            "rewardpoints": 150,
            "customerId": 1
        },
        {
            "transId": 3,
            "transDate": "2024-06-27",
            "transAmt": 120,
            "rewardpoints": 90,
            "customerId": 1
        },
        {
            "transId": 52,
            "transDate": "2024-11-28",
            "transAmt": 200,
            "rewardpoints": 250,
            "customerId": 1
        }
    ],
    "totalRewardPoints": 580,
    "rewardpoints_3month": 490,
    "monthWiseRewardPoint": {
        "2024-06": 90,
        "2024-11": 490
    }
}

Url: http://localhost:8080/customer/allcustomers

To get the customer details with transaction List and reward points(Monthly,3month, total) for all the customers

Method : GET


Customer Id :1
 [
    {
        "customerId": 1,
        "customerName": "Customer1",
        "address": "Address1",
        "emailID": "email@gmail.com",
        "phone": 123456789,
        "created_at": "2024-11-27",
        "created_by": "Customer1",
        "updated_at": null,
        "updated_by": null,
        "transList": [
            {
                "transId": 1,
                "transDate": "2024-11-27",
                "transAmt": 120,
                "rewardpoints": 90,
                "customerId": 1
            },
            {
                "transId": 2,
                "transDate": "2024-11-27",
                "transAmt": 150,
                "rewardpoints": 150,
                "customerId": 1
            },
            {
                "transId": 3,
                "transDate": "2024-06-27",
                "transAmt": 120,
                "rewardpoints": 90,
                "customerId": 1
            },
            {
                "transId": 52,
                "transDate": "2024-11-28",
                "transAmt": 200,
                "rewardpoints": 250,
                "customerId": 1
            }
        ],
        "totalRewardPoints": 580,
        "rewardpoints_3month": 490,
        "monthWiseRewardPoint": {
            "2024-06": 90,
            "2024-11": 490
        }
    },
    {
        "customerId": 2,
        "customerName": "Customer2",
        "address": "Address2",
        "emailID": "email2@gmail.com",
        "phone": 234567891,
        "created_at": "2024-11-27",
        "created_by": "Customer2",
        "updated_at": null,
        "updated_by": null,
        "transList": [
            {
                "transId": 4,
                "transDate": "2024-10-27",
                "transAmt": 130,
                "rewardpoints": 110,
                "customerId": 2
            }
        ],
        "totalRewardPoints": 110,
        "rewardpoints_3month": 110,
        "monthWiseRewardPoint": {
            "2024-10": 110
        }
    },
    {
        "customerId": 52,
        "customerName": "Customer3",
        "address": "Address3",
        "emailID": "email3@gmail.com",
        "phone": 134567892,
        "created_at": "2024-11-27",
        "created_by": "Customer3",
        "updated_at": null,
        "updated_by": null,
        "transList": [],
        "totalRewardPoints": 0,
        "rewardpoints_3month": 0,
        "monthWiseRewardPoint": {}
    },
    {
        "customerId": 102,
        "customerName": "Customer4",
        "address": "Address4",
        "emailID": "email4@gmail.com",
        "phone": 134567928,
        "created_at": "2024-11-28",
        "created_by": "Customer4",
        "updated_at": null,
        "updated_by": null,
        "transList": [],
        "totalRewardPoints": 0,
        "rewardpoints_3month": 0,
        "monthWiseRewardPoint": {}
    }
]

URL: http://localhost:8080/transaction 

To create transaction

Method: POST method

request : 

	{
        "transAmt":200,             
        "customerId":1  
        }


Postman Collection: rewardpoint_cal_demo.postman_collection.
Import this collection file in Postman and test the endpoints





  
  


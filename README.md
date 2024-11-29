Technology : 
Spring-boot
MySql
Java 17

Rest endpoints

1.URL:  http://localhost:8080/customer
Method : post
To create a Customer data and store it in MySQLDB
Input Json to test in postman
{
		"customerName":"Customer1",
		"address" :"Address1",
		"emailID":"email@gmail1.com",
		"phone":134567928
		}
  
2.Url To get the customerdetail with transaction List and total rewardpoints for the given customerId
 http://localhost:8080/customer/{customerId}/transactions
 
 3.Url To get the customerdetail with transaction List and total rewardpoints,sum of 3 month reward points and  monthwise reward point report for the given customerId
  http://localhost:8080/customer/{customerId}/rewardpointsum
  
4.Url To get the customerdetail with transaction List and rewardpoints(Monthly,3month,total) for all the customers
http://localhost:8080/customer/allcustomers

To test the code. MYSQL should be installed.
Customer and Transaction Tables are used.
Script to create tables;
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
Insert Query
Insert into transaction (trans_id,trans_date,Trans_Amt, Reward_Points,customer_Id) values (4,'2024-10-27',130,110,2);	

Postman Collection : rewardpoint_cal_demo.postman_collection
Uploaded this collection file.Import the file in postman and test the endpoint urls

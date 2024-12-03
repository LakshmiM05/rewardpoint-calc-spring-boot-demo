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

	

Postman Collection : rewardpoint_cal_demo.postman_collection
Uploaded this collection file.Import the file in postman and test the endpoints

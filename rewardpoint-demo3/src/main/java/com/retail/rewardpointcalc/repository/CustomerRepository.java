package com.retail.rewardpointcalc.repository;


import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.retail.rewardpointcalc.entity.Customer;
import com.retail.rewardpointcalc.model.CustomerResponse;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	// @Query("SELECT DISTINCT o FROM Order o JOIN o.orderDetails od JOIN od.product p"
	  //          + " WHERE p.name LIKE %?1%")
	 
	/* @Query(value="SELECT customer.customer_Id, customer.address,customer.created_at, customer.customer_Name,customer.EmailID,customer.phone,customer.created_by,customer.updated_at,customer.updated_by,Transaction.Trans_Id,"
			+" Transaction.Trans_Date,Transaction.Trans_Amt,Transaction.Reward_Points "
			 +"FROM customer INNER JOIN Transaction "
			 +"ON customer.customer_Id = Transaction.customer_Id and customer.customer_Id ="+'1',nativeQuery = true) */
	  //  public Optional<Customer> findByCustomerId(Integer customerid);   
	    
	    
	    /*@Query(value="SELECT customer.customer_Id, sum(Transaction.Reward_Points) "
				
				 +"FROM customer INNER JOIN Transaction "
				 +"ON customer.customer_Id = Transaction.customer_Id and customer.customer_Id ="+'1' + " and Transaction.trans_Date > date_sub(now(),Interval 3 month) ",
				 nativeQuery = true)
	    public Optional<Customer> find(Integer customerid);   */
	    
	    
	/*	@Query(value = "SELECT customer.customer_Id,customer.address,customer.created_at, customer.customer_Name,customer.EmailID,customer.phone,customer.created_by,customer.updated_at,customer.updated_by, sum(Transaction.Reward_Points) as rewardsum "

				+ "FROM customer INNER JOIN Transaction "
				+ "ON customer.customer_Id = Transaction.customer_Id and customer.customer_Id =:customer_Id and Transaction.trans_Date > date_sub(now(),Interval 3 month) ", nativeQuery = true)
		public Optional<Customer> find(@Param("customer_Id") Integer customer_Id);*/
	    
	/*	@Query(value = "SELECT customer.customer_Id,customer.address,customer.created_at, customer.customer_Name,customer.EmailID,customer.phone,customer.created_by,customer.updated_at,customer.updated_by,Transaction.Trans_Id, "
				+" Transaction.Trans_Date,Transaction.Trans_Amt,Transaction.Reward_Points "
				+ "FROM customer INNER JOIN Transaction "
				+ "ON customer.customer_Id = Transaction.customer_Id and customer.customer_Id =:customer_Id and Transaction.trans_Date > date_sub(now(),Interval 3 month) ", nativeQuery = true)
		public Optional<Customer> find(@Param("customer_Id") Integer customer_Id);*/
	    
	    
	   /* @Query(value = "SELECT customer.customer_Id,customer.address,customer.created_at, customer.customer_Name,customer.EmailID,customer.phone,customer.created_by,customer.updated_at,customer.updated_by,Transaction.Trans_Id, "
				+" Transaction.Trans_Date,Transaction.Trans_Amt,Transaction.Reward_Points "
				+ "FROM customer INNER JOIN Transaction "
				+ "ON customer.customer_Id = Transaction.customer_Id and customer.customer_Id =:customer_Id and Transaction.trans_Date > date_sub(now(),Interval 3 month) ", nativeQuery = true)
		public Optional<Customer> find(@Param("customer_Id") Integer customer_Id);*/
	    
	    
	    public Optional<Customer> findByCustomerId(Integer customerid);   
	    
	   
	    
	    
	  //  public Optional<Customer> findByCustomerIdAndTrans_DateBetween(Integer customerid,Date trans_DateStart,Date trans_DateEnd);  
	    
	    
	   

	    

}

package com.retail.rewardpointcalc.model;

import java.util.ArrayList;
import java.util.List;

import com.retail.rewardpointcalc.entity.Customer;

public class CustomerResponseMapper {
	
	
	//List<TransactionResponse> transResponList = new ArrayList<TransactionResponse>();
	//List<Transaction> transList = new ArrayList<Transaction>();
    
    public static CustomerResponse mapToCustomerResponse(Customer customer, CustomerResponse customerResponse) {
    	customerResponse.setCustomerId(customer.getCustomerId());
    	customerResponse.setCustomerName(customer.getCustomerName());
    	customerResponse.setCreated_at(customer.getCreated_at());
    	customerResponse.setCreated_by(customer.getCreated_by());
    	customerResponse.setAddress(customer.getAddress());
    	customerResponse.setEmailID(customer.getEmailID());
    	customerResponse.setPhone(customer.getPhone());
    	customerResponse.setUpdated_at(customer.getUpdated_at());
    	customerResponse.setUpdated_by(customer.getUpdated_by());
    	
    	customerResponse.setTransList(CustomerResponseMapper.mapToTransactionResList(customer.getTransActionList(),customerResponse.getTransList()));
        return customerResponse;
    }
    
    
    public static List<TransactionResponse> mapToTransactionResList(List<com.retail.rewardpointcalc.entity.Transaction> transactionList,List<TransactionResponse> listTransResp) {
    	 // Numbers.forEach((n) -> System.out.println(n)); 
    	  transactionList.forEach(transaction -> {    		  
    		 
    		  listTransResp.add(TransactionResponseMapper.mapToTransactionResponse(transaction,new TransactionResponse()));
    	  });
    	//TransactionResponseMapper.mapToTransactionResponse(customer.getTransActionList().get(0), new TransactionResponse());
    	return listTransResp;
    }
    
    
    
}

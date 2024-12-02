package com.retail.rewardpointcalc.model;

import java.util.List;
import java.util.Optional;

import com.retail.rewardpointcalc.entity.Customer;

public class CustomerResponseMapper {

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
		
		

		customerResponse.setTransList(CustomerResponseMapper.mapToTransactionResList(customer.getTransActionList(),
				customerResponse.getTransList().get()));
		return customerResponse;
	}

	public static Optional<List<TransactionResponse>> mapToTransactionResList(
			List<com.retail.rewardpointcalc.entity.Transaction> transactionList,
			List<TransactionResponse> listTransResp) {

		if (transactionList != null) {
			transactionList.stream().forEach(transaction -> {
				listTransResp.add(
						
						TransactionResponseMapper.mapToTransactionResponse(transaction, new TransactionResponse()));
			});
		}

		return Optional.ofNullable(listTransResp);
	}

}

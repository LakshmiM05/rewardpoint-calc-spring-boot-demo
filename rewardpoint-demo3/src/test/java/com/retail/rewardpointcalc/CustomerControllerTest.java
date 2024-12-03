package com.retail.rewardpointcalc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.retail.rewardpointcalc.controller.CustomerController;
import com.retail.rewardpointcalc.entity.Customer;
import com.retail.rewardpointcalc.entity.Transaction;
import com.retail.rewardpointcalc.model.CustomerRequest;
import com.retail.rewardpointcalc.model.CustomerResponse;
import com.retail.rewardpointcalc.model.TransactionResponse;
import com.retail.rewardpointcalc.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerRepository customerRepository;

	@Test
	public void testCreateCustomer() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		CustomerRequest customer = new CustomerRequest("customerName", "address", "howtodoinjava@gmail.com",
				"1234567889");
		when(customerRepository.save(any(Customer.class))).thenReturn(new Customer());
		ResponseEntity<CustomerResponse> responseEntity = customerController.createCustomer(customer);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
		assertThat(responseEntity.getBody().equals(CustomerResponse.class));

	}

	@Test
	public void testGetCustomerDataById() {
		CustomerRequest customer = new CustomerRequest("customerName", "address", "howtodoinjava@gmail.com",
				"1234567889");
		List<TransactionResponse> transList = new ArrayList<TransactionResponse>();

		Optional<Customer> custresponse = Optional.of(new Customer(1, "customerName", "address",
				"howtodoinjava@gmail.com", 1234567889, new ArrayList<Transaction>(), null, "customerName", null, null));

		when(customerRepository.findById(1)).thenReturn(custresponse);

		ResponseEntity<CustomerResponse> customerResponse = customerController.getCustomerData(1);
		customerResponse.getBody().getCustomerName();

		assertThat(customerResponse.getBody().getCustomerName()).isEqualTo(custresponse.get().getCustomerName());
		assertThat(customerResponse.getBody().getCustomerId() == (custresponse.get().getCustomerId()));
	}

	@Test
	public void testGetRewardSum() {

		Transaction transAction = new Transaction();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transAction.setTransId(1);
		transAction.setCustomer(null);
		transAction.setCustomerId(1);
		transAction.setRewardPoints(90);
		transAction.setTransAmt(120);
		transAction.setTransDate(new java.sql.Date(0));
		transactionList.add(transAction);
				Optional<Customer> custresponse = Optional.of(new Customer(1, "customerName", "address",
				"howtodoinjava@gmail.com", 1234567889, transactionList, null, "customerName", null, null));

		when(customerRepository.findByCustomerId(1)).thenReturn(custresponse);

		ResponseEntity<CustomerResponse> customerResponse = customerController.getCustomerWith3MonthPoint(1);
		customerResponse.getBody().getCustomerName();

		assertThat(customerResponse.getBody().getCustomerName()).isEqualTo(custresponse.get().getCustomerName());
		assertThat(customerResponse.getBody().getCustomerId() == (custresponse.get().getCustomerId()));
		//assertThat(customerResponse.getBody().getTransList().get().getRewardpoints() == 90);
	}

}

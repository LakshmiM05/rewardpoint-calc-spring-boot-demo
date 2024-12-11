package com.retail.rewardpointcalc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;

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
import com.retail.rewardpointcalc.controller.TransactionController;
import com.retail.rewardpointcalc.entity.Customer;
import com.retail.rewardpointcalc.entity.Transaction;
import com.retail.rewardpointcalc.model.CustomerRequest;
import com.retail.rewardpointcalc.model.CustomerResponse;
import com.retail.rewardpointcalc.model.TransactionRequest;
import com.retail.rewardpointcalc.model.TransactionResponse;
import com.retail.rewardpointcalc.repository.CustomerRepository;
import com.retail.rewardpointcalc.repository.TransactionRepository;
import com.retail.rewardpointcalc.service.RewardPointCalcService;
@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
	
	 @InjectMocks
	 TransactionController  transactionController;

	    @Mock
	    TransactionRepository transactionRepository;
	    
	    @Mock
	    //TransactionService transactionService;
	    private RewardPointCalcService rewardPointCalcService;

	    @Test
	    public void testCreateCustomer()
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));	 
	        TransactionRequest transreq = new TransactionRequest();
	        transreq.setCustomerId(1);
	        transreq.setRewardpoints(120);
	        transreq.setTransAmt(100);
	        transreq.setTransDate(new Date(0));
	        transreq.setTransId(1l);
	     
	        when(transactionRepository.save(any(Transaction.class))).thenReturn(new Transaction());	
	        when(rewardPointCalcService.getCustomerRewardPoint(any(Integer.class))).thenReturn(20);	
	        ResponseEntity<TransactionResponse> responseEntity = transactionController.createTransaction(transreq);	        
	        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
	        assertThat( responseEntity.getBody().equals(TransactionResponse.class));
	        
	    }

}

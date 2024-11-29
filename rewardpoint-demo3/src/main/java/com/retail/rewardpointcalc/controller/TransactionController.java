package com.retail.rewardpointcalc.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.rewardpointcalc.entity.Transaction;
import com.retail.rewardpointcalc.model.TransactionRequest;
import com.retail.rewardpointcalc.repository.TransactionRepository;
import com.retail.rewardpointcalc.service.RewardPointCalcService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private RewardPointCalcService rewardPointCalcService;
	
	@PostMapping("/transaction")
	public ResponseEntity<String> createTransaction(@RequestBody TransactionRequest transactionRequest) {		

		Transaction transEntity = Transaction.builder().customerId(transactionRequest.getCustomerId())
				.rewardPoints(rewardPointCalcService.getCustomerRewardPoint(transactionRequest.getTransAmt()))
				.transAmt(transactionRequest.getTransAmt()).transDate(new Date(System.currentTimeMillis())).build();
		repository.save(transEntity);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}
}


package com.retail.rewardpointcalc.model;

import com.retail.rewardpointcalc.entity.Transaction;

public class TransactionResponseMapper {
	int totalRewardPnt = 0;

	public static TransactionResponse mapToTransactionResponse(Transaction transaction,
			TransactionResponse transactionResponse) {

		transactionResponse.setCustomerId(Long.valueOf(transaction.getCustomerId()));
		transactionResponse.setRewardpoints(transaction.getRewardPoints());
		transactionResponse.setTransAmt(transaction.getTransAmt());
		transactionResponse.setTransDate(transaction.getTransDate());
		transactionResponse.setTransId(transaction.getTransId());

		return transactionResponse;
	}

}

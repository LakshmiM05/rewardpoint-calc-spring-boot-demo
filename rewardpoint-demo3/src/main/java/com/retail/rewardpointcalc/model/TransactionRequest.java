package com.retail.rewardpointcalc.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

	private Long transId;
	private Date transDate;
	private int transAmt;
	private int rewardpoints;
	private int customerId;
	
	
}

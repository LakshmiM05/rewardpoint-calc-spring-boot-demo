package com.retail.rewardpointcalc.model;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Transaction {
	private Long transId;
	private Date transDate;
	private int transAmt;
	private int rewardpoints;
	private Long customerId;
}

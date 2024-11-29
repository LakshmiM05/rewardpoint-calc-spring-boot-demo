package com.retail.rewardpointcalc.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RewardPointResponse {
	private String customerName;
	private Long customerId;
	private String emailID;
	private String mobileNumber;
	private List<Transaction> listOfTransaction;
	private int monthlyTotalRewardPoint;
	}

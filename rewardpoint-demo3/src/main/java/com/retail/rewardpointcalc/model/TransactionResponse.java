package com.retail.rewardpointcalc.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
	private int transId;
	private Date transDate;
	private int transAmt;
	private int rewardpoints;
	private Long customerId;

}

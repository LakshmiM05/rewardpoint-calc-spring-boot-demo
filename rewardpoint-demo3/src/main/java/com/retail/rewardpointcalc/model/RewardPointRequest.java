package com.retail.rewardpointcalc.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RewardPointRequest {
	
	private Long customerId;
	private String customerName;
	private int transActionAmt;
	private List<Integer> transActionAmtList=new ArrayList<Integer>();

}

package com.retail.rewardpointcalc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.rewardpointcalc.model.RewardPointRequest;
import com.retail.rewardpointcalc.model.RewardPointResponse;

@Service
public class RewardPointCalcService {

	public int getCustomerRewardPoint(Integer transAmt) {

		// int transAmt = rewardPointRequest.getTransActionAmt();
		Integer rewardPoint = 0;
		Integer rewardPointBelowMax = 0;
		Integer rewardPointAboveMax = 0;
		Integer minLimit = 50;
		Integer maxLimit = 100;

		if (transAmt >= maxLimit) {
			// Calculate reward point for amt lesser than 100
			// if(transAmt >=minLimit && transAmt <=maxLimit) {
			rewardPointBelowMax = calculateRewardPoint(50, 1);
			// }
			// Calculate reward point for amt greater than 100
			rewardPointAboveMax = calculateRewardPoint(transAmt - 100, 2);
			rewardPoint = rewardPointBelowMax + rewardPointAboveMax;
		} else if (transAmt > minLimit) {
			rewardPoint = calculateRewardPoint(transAmt - minLimit, 1);
		}
		/*
		 * else if(transAmt ==minLimit) { rewardPoint = calculateRewardPoint(1,1); }
		 */

		return rewardPoint;
	}

	private int calculateRewardPoint(int eligbleAmt, int point) {
		int rewardPoint = eligbleAmt * point;
		return rewardPoint;
	}

	public RewardPointResponse buildRewardPointResponse(RewardPointRequest rewardPointRequest) {
		// int totalvalue=0;
		RewardPointResponse rewardPointResponse = new RewardPointResponse();
		rewardPointResponse.setCustomerId(rewardPointRequest.getCustomerId());
		rewardPointResponse.setCustomerName(rewardPointRequest.getCustomerName());
		// rewardPointResponse.setMobileNumber(rewardPointRequest.get);
		rewardPointResponse.setMonthlyTotalRewardPoint(getCustomerRewardPoint(rewardPointRequest.getTransActionAmt()));

		// For Multiple transactions
		List<Integer> rewardPointList = new ArrayList<Integer>();

		rewardPointRequest.getTransActionAmtList().forEach(transAmtValue -> {
			int rewardpointvalue = getCustomerRewardPoint(transAmtValue);
			//System.out.println("RewardPoint value::  " + rewardpointvalue);
			// calculateTotal(rewardpointvalue);
			rewardPointList.add(rewardpointvalue);
		});

		Integer sum = rewardPointList.stream().mapToInt(Integer::intValue).sum();
		rewardPointResponse.setMonthlyTotalRewardPoint(sum);
		return rewardPointResponse;

	}

}

package com.retail.rewardpointcalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.rewardpointcalc.model.RewardPointRequest;
import com.retail.rewardpointcalc.model.RewardPointResponse;
import com.retail.rewardpointcalc.service.RewardPointCalcService;

@RestController
public class RewardPointCalcController {

	@Autowired
	RewardPointCalcService rewardPointCalcService;

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello World!!!!";
	}

	@GetMapping("/rewardpoint/find-by-id/{customerId}")
	public String findRewardPointById(@PathVariable Long customerId) {
		return null;
	}

	@PostMapping("/rewardpoint")
	public RewardPointResponse findRewardPoint(@RequestBody RewardPointRequest rewardPointRequest) {
		return rewardPointCalcService.buildRewardPointResponse(rewardPointRequest);
	}

}

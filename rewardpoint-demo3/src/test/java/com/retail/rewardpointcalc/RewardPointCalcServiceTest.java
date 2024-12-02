package com.retail.rewardpointcalc;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.retail.rewardpointcalc.service.RewardPointCalcService;


@ExtendWith(MockitoExtension.class)
public class RewardPointCalcServiceTest {
	
	@InjectMocks
	private RewardPointCalcService rewardPointCalcService;

	@Test
	public void testRewardPointCalWithTransAmtGt100() {
		Integer transAmt = 120;
		Integer rewardpoint = rewardPointCalcService.getCustomerRewardPoint(transAmt);
		assertThat(rewardpoint).isEqualTo(90);
	}

	@Test
	public void testRewardPontCalWithTransAmtLessThan100() {
		Integer transAmt = 90;
		Integer rewardpoint = rewardPointCalcService.getCustomerRewardPoint(transAmt);
		assertThat(rewardpoint).isEqualTo(40);
	}

	@Test
	public void testRewardPointCalWithTransAmtGreterThan50() {
		Integer transAmt = 60;
		Integer rewardpoint = rewardPointCalcService.getCustomerRewardPoint(transAmt);
		assertThat(rewardpoint).isEqualTo(10);
	}

	@Test
	public void testRewardPontCalWithTransAmtLesserThan50() {
		Integer transAmt = 40;
		Integer rewardpoint = rewardPointCalcService.getCustomerRewardPoint(transAmt);
		assertThat(rewardpoint).isEqualTo(0);
	}

}

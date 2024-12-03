package com.retail.rewardpointcalc.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CustomerListResponse {
	@Builder.Default
	private List<CustomerResponse> customerResponseList = new ArrayList<CustomerResponse>();

}

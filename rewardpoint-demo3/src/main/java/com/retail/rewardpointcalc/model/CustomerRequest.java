package com.retail.rewardpointcalc.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {
	
	private String customerName;
	private String address ;
	private String  emailID; 
	private int  phone ;

}

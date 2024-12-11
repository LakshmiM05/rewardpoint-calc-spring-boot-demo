package com.retail.rewardpointcalc.model;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
	@NotNull(message = "Enter a valid transaction amount")
	@Min(value = 10, message = "Minimum Tranasaction Amount Should be 10")
	@Max(value = 10000, message = "Maximum Tranasaction Amount Should be 10000")
	private int transAmt;
	private int rewardpoints;
	@NotNull(message = "Enter a valid Customer Id")
	private int customerId;

}

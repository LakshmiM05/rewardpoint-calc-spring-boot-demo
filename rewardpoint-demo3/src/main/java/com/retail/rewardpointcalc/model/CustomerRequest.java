package com.retail.rewardpointcalc.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerRequest {
	@NotEmpty(message = "Enter a valid Customer Name")
	private String customerName;
	@Size(min = 5, max = 1000, message = "Address should have a length between 5 and 1000 characters.")
	private String address;
	@Email(message = "Please enter a valid email Id")
	@NotEmpty(message = "Email cannot be NULL")
	private String emailID;
	@Pattern(regexp = "^[0-9]{10}$", message = "Customer phone number must be a 10-digit number.")
	private String phone;

}

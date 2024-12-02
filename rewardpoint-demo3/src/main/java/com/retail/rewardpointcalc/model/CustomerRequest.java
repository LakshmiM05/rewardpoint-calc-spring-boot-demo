package com.retail.rewardpointcalc.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	//@NotNull(message = "Enter a valid Customer Name")
	private String customerName;
	@Size(min = 10, max = 100, message = "Address should have a length between 10 and 100 characters.")
	private String address;
	@Email(message = "Please enter a valid email Id")
	@NotEmpty(message = "Email cannot be NULL")
	private String emailID;
	//@Pattern(regexp = "^[0-9]{10}$", message = "Customer phone number must be a 10-digit number.")
	private int phone;

}

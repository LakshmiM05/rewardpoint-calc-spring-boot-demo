package com.retail.rewardpointcalc.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponseDto {

	private String apiPath;
	private HttpStatus error;
	private int errorCode;
	private String errorMessage;
	private LocalDateTime errorTime;

}

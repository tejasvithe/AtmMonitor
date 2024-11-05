package com.intuitive.atm.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class ATMException extends RuntimeException {

	@Getter
	private final HttpStatus httpStatus;
	@Getter
	private final boolean slackFlag;

	public ATMException(String msg) {
		super(msg);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.slackFlag = false;
	}

	public ATMException(String msg, HttpStatus httpStatus) {
		super(msg);
		this.httpStatus = httpStatus;
		this.slackFlag = false;
	}

	public ATMException(String msg, HttpStatus httpStatus, boolean slack) {
		super(msg);
		this.httpStatus = httpStatus;
		this.slackFlag = slack;
	}

}

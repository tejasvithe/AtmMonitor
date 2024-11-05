package com.intuitive.atm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.exception.ATMException;
import com.intuitive.atm.repository.ITransactionLogRepository;
import com.intuitive.atm.service.ICustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

	private final ICustomerService customerService;

	@GetMapping("count")
	public BaseResponse getTotalCustomersLast24Hours() {

		try {
			log.info("request for fetching customer count in 24 hour started");

			BaseResponse response = customerService.countCustomersInLast24Hours();
			
			log.info("request for fetching customer count in 24 hour completed");
			return response;
		} catch (ATMException e) {
			throw new ATMException("exception occured while fetching total customer count", e.getHttpStatus());
		} catch (Exception e) {
			throw new ATMException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

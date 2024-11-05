package com.intuitive.atm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.dto.request.TransactionFilterRequest;
import com.intuitive.atm.exception.ATMException;
import com.intuitive.atm.repository.ITransactionLogRepository;
import com.intuitive.atm.service.ITransactionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("transaction")
@RequiredArgsConstructor
@Slf4j
@Validated
public class TransactionController {

	private final ITransactionService transactionService;
	
	@PostMapping("breakdown")
	public BaseResponse transactions( @RequestBody @Valid TransactionFilterRequest request ) {

		try {
			log.info("request for fethcing transaction logs started");

			BaseResponse response = transactionService.fetchTransactions(request);
			log.info("request for fetching transaction logs completed");
			return response;
		} catch (ATMException e) {
			throw new ATMException("exception occured while fetching transaction breakdown", e.getHttpStatus());
		} catch (Exception e) {
			throw new ATMException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

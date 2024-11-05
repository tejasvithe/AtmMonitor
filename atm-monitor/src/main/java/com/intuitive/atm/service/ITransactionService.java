package com.intuitive.atm.service;

import java.time.LocalDateTime;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.dto.request.TransactionFilterRequest;

public interface ITransactionService {
	
	BaseResponse fetchTransactions(TransactionFilterRequest request);
	
 
}

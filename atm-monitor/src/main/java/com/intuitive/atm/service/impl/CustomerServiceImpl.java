package com.intuitive.atm.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.entity.TransactionLogEntity;
import com.intuitive.atm.repository.ITransactionLogRepository;
import com.intuitive.atm.service.ICustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
	private final ITransactionLogRepository transactionLogRepository;
	
	@Override
	public BaseResponse countCustomersInLast24Hours() {
	
		Map<String, Object> data = new HashMap<>();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime past
        = now.minus(24, ChronoUnit.HOURS);
		List<TransactionLogEntity> transactions  = transactionLogRepository.findAllByCreatedDateBetween(past,now);
		
		long count = transactions.stream().map(t->t.getCustomerId()).distinct().count();
		
		data.put("customerCount",count);
		
		return BaseResponse.builder().message("success").success(true).data(data).build();
	}

}

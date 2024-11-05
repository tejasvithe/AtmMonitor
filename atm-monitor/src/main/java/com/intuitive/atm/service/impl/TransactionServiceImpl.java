package com.intuitive.atm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.dto.request.TransactionFilterRequest;
import com.intuitive.atm.dto.response.TransactionDetailsDto;
import com.intuitive.atm.dto.response.TransactionResponse;
import com.intuitive.atm.entity.TransactionLogEntity;
import com.intuitive.atm.enums.FailedStatus;
import com.intuitive.atm.enums.TransactionType;
import com.intuitive.atm.mapper.TransactionMapper;
import com.intuitive.atm.repository.ITransactionLogRepository;
import com.intuitive.atm.service.ITransactionService;
import com.intuitive.atm.specifications.TransactionSpecifications;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements ITransactionService {

	private final ITransactionLogRepository transactionLogRepository;
	private final TransactionSpecifications transactionSpecifications;
	private final TransactionMapper transactionMapper;

	@Override
	public BaseResponse fetchTransactions(TransactionFilterRequest request) {
		log.info("fetch transaction logs setvice call started");
		
		Long totalCount = transactionLogRepository
				.count(transactionSpecifications.getTransactionSpecifications(request));

		Integer totalPages = (int) Math.ceil(totalCount / Double.valueOf(request.getPageSize()));

		Page<TransactionLogEntity> transactionLogs = transactionLogRepository.findAll(
				transactionSpecifications.getTransactionSpecifications(request),
				PageRequest.of(request.getPageNo(), request.getPageSize()));
		
		 Map<TransactionType, List<TransactionDetailsDto>> sucessTransactiondata = new HashMap<>();
		 Map<FailedStatus, List<TransactionDetailsDto>> failedTransaction = new HashMap<>();
		 
		 transactionMapper.transactionLogsToResponseDto(transactionLogs,sucessTransactiondata,failedTransaction);
		 
		 log.info("fetch transaction logs setvice call completed");

		return TransactionResponse.builder().sucessTransactiondata(sucessTransactiondata).failedTransaction(failedTransaction).totalCount(totalCount).totalPageCount(totalPages).build();
	}

}

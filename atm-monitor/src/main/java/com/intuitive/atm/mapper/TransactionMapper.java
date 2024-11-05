package com.intuitive.atm.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.intuitive.atm.dto.response.TransactionDetailsDto;
import com.intuitive.atm.entity.TransactionLogEntity;
import com.intuitive.atm.enums.FailedStatus;
import com.intuitive.atm.enums.TransactionType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionMapper {
	
	public void transactionLogsToResponseDto(Page<TransactionLogEntity> transactionLogs, Map<TransactionType, List<TransactionDetailsDto>> sucessTransactiondata, Map<FailedStatus, List<TransactionDetailsDto>> failedTransaction) {
		
		log.info("transaction mapper call started");
		
		transactionLogs.forEach(transaction ->{
			if(transaction.isSuccess()) {
			List<TransactionDetailsDto> successList =	sucessTransactiondata.getOrDefault(transaction.getTransactiontype(), new ArrayList<>());
			TransactionDetailsDto tran = TransactionDetailsDto.builder().build();
			BeanUtils.copyProperties(transaction, tran);
			successList.add(tran);
			sucessTransactiondata.put(transaction.getTransactiontype(), successList);
				
			} else {
				
				List<TransactionDetailsDto> failedList =	sucessTransactiondata.getOrDefault(transaction.getFailedStatus(), new ArrayList<>());
				TransactionDetailsDto tran = TransactionDetailsDto.builder().build();
				BeanUtils.copyProperties(transaction, tran);
				failedList.add(tran);
				failedTransaction.put(transaction.getFailedStatus(), failedList);
				
			}
		});
		
		log.info("transaction mapper call completed");
		
	}

}

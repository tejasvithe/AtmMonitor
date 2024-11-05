package com.intuitive.atm.dto.response;

import java.util.List;
import java.util.Map;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.enums.FailedStatus;
import com.intuitive.atm.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends BaseResponse {

	private Map<TransactionType, List<TransactionDetailsDto>> sucessTransactiondata;
	private Map<FailedStatus, List<TransactionDetailsDto>> failedTransaction;

	private Integer totalPageCount;
	private Long totalCount;

}

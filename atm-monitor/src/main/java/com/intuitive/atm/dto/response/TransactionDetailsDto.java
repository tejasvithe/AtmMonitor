package com.intuitive.atm.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.enums.FailedStatus;
import com.intuitive.atm.enums.TransactionStatus;
import com.intuitive.atm.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TransactionDetailsDto {
	
	private Long customerId;
	private Long atmId;
	private TransactionStatus status;
	private LocalDateTime createdAt;
	private FailedStatus failedStatus;

}

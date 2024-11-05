package com.intuitive.atm.dto.request;

import java.time.LocalDateTime;

import com.intuitive.atm.enums.FailedStatus;
import com.intuitive.atm.enums.TransactionType;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFilterRequest {

	private Boolean isSuccess;
	@NotNull
	private Integer pageNo;
	@NotNull
	private Integer pageSize;
	private LocalDateTime start;
	private LocalDateTime end;
	
	private TransactionType transactionType;
	
	private FailedStatus failedStatus;
	

}

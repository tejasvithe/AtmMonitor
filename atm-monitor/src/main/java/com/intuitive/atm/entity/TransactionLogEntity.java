package com.intuitive.atm.entity;

import com.intuitive.atm.enums.FailedStatus;
import com.intuitive.atm.enums.TransactionStatus;
import com.intuitive.atm.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="transaction_logs")
public class TransactionLogEntity extends BaseEntity {
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactiontype;
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionstatus;
	private Long customerId;
	private Long atmId;
	private boolean isSuccess; // true for success, false for failure
	private FailedStatus failedStatus;

}

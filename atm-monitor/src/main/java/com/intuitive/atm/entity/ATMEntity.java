package com.intuitive.atm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name ="atms")
public class ATMEntity extends BaseEntity {
	
	private String name;
	private String bankName;
	private String location;
	
	// other bank details

}

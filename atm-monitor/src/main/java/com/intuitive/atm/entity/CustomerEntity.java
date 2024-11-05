package com.intuitive.atm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name ="customers")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CustomerEntity extends BaseEntity {
	
	private String name;
	private String bankDetails;
	private String cardDetails;
	
	//other customer details;
	

}

package com.intuitive.atm.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  public Long id;

	  @CreatedDate
	  @Column(name = "created_date", nullable = false, updatable = false)
	  private LocalDateTime createdDate;

	  @LastModifiedDate
	  @Column(name = "updated_date", nullable = false, updatable = true)
	  private LocalDateTime updatedDate;

	  @Column(name = "created_by")
	  private String createdBy;

	  @Column(name = "updated_by")
	  private String updatedBy;

}

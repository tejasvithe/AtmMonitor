package com.intuitive.atm.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.intuitive.atm.dto.request.TransactionFilterRequest;
import com.intuitive.atm.entity.TransactionLogEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionSpecifications {
	
	public Specification getTransactionSpecifications(
			TransactionFilterRequest transactionFilterRequest) {
		
		Specification specification = new Specification<TransactionLogEntity>() {

			@Override
			public Predicate toPredicate(Root<TransactionLogEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				 List<Predicate> predicates = new ArrayList<>();
				 
				 if (Objects.nonNull(transactionFilterRequest.getIsSuccess())) {
			          predicates.add(criteriaBuilder.equal(root.get("isSuccess"),
			        		  transactionFilterRequest.getIsSuccess()));
			        }
				 
				  if (Objects.nonNull(transactionFilterRequest.getStart())) {
			          predicates.add(
			              criteriaBuilder.greaterThanOrEqualTo(
			                  root.get("createdDate"),
			                  transactionFilterRequest.getStart()));
			        }

			        if (Objects.nonNull(transactionFilterRequest.getEnd())) {
			          predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdDate"), transactionFilterRequest.getEnd()));
			        }
			        
			        if (Objects.nonNull(transactionFilterRequest.getTransactionType())) {
				          predicates.add(
				              criteriaBuilder.equal(
				                  root.get("transactiontype"),
				                  transactionFilterRequest.getTransactionType()));
				        }
			        
			        if (Objects.nonNull(transactionFilterRequest.getFailedStatus())) {
				          predicates.add(
				              criteriaBuilder.equal(
				                  root.get("failedStatus"),
				                  transactionFilterRequest.getFailedStatus()));
				        }
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
			
		};
		
		return specification;
		
	}

}

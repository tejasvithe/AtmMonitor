package com.intuitive.atm.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intuitive.atm.entity.TransactionLogEntity;

@Repository
public interface ITransactionLogRepository extends JpaRepository<TransactionLogEntity, Long>,JpaSpecificationExecutor<TransactionLogEntity>,
PagingAndSortingRepository<TransactionLogEntity, Long> {
	
	
	List<TransactionLogEntity> findAllByIsSuccessAndCreatedDateBetween(boolean isSuccess,LocalDateTime start,LocalDateTime end);
	
	
//	@Query("select COUNT(DISTINCT c.customerId) from TransactionLog a where a.createdDate <= NOW() and a.createdDate >= :end")
//	long countCustomersInLast24Hours(@Param("end") LocalDateTime end);
	
	List<TransactionLogEntity> findAllByCreatedDateBetween(LocalDateTime start,LocalDateTime end);
	
	
}

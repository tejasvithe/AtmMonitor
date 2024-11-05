package com.intuitive.atm.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuitive.atm.entity.VideoLogsEntity;

@Repository
public interface IVideoLogsRepository extends JpaRepository<VideoLogsEntity, Long> {
	
	List<VideoLogsEntity> findByCreatedDateBetween(LocalDateTime start,LocalDateTime end);

}

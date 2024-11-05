package com.intuitive.atm.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.entity.VideoLogsEntity;
import com.intuitive.atm.mapper.VideoMapper;
import com.intuitive.atm.repository.IVideoLogsRepository;
import com.intuitive.atm.service.IVideoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements IVideoService {
	
private final IVideoLogsRepository videoLogsRepository;
private final VideoMapper videoMapper;

	@Override
	public BaseResponse fetchVideoLogs(LocalDateTime start, LocalDateTime end) {
		
		List<VideoLogsEntity> videoLogs =	videoLogsRepository.findByCreatedDateBetween(start, end);
		return videoMapper.videoLogListToVideoLogsResponse(videoLogs);
	}

}

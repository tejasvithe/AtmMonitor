package com.intuitive.atm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.dto.response.VideoLogsDetailsDto;
import com.intuitive.atm.dto.response.VideoLogsResponse;
import com.intuitive.atm.entity.VideoLogsEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class VideoMapper {
	public VideoLogsResponse videoLogListToVideoLogsResponse(List<VideoLogsEntity> videoLogs) {
		
		log.info("video log mapper call started");
		
		 List<VideoLogsDetailsDto> videoLogList = new ArrayList<>();
		 
		 videoLogs.forEach(videoLog->{
			 VideoLogsDetailsDto videoLogsResponse = VideoLogsDetailsDto.builder().build();
			 BeanUtils.copyProperties(videoLog, videoLogsResponse);
			 videoLogList.add(videoLogsResponse);
		 });
		 
		 log.info("video log mapper call completed");
		
		return VideoLogsResponse.builder().success(true).message("success").videoLogs(videoLogList).build();
	}

}

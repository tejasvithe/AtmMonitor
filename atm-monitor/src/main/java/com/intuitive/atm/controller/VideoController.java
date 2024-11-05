package com.intuitive.atm.controller;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.exception.ATMException;
import com.intuitive.atm.service.IVideoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("camera")
@RequiredArgsConstructor
public class VideoController {
	
	private final IVideoService videoService;

	@GetMapping("data")
	public BaseResponse cameraData(@RequestParam("startDate")LocalDateTime startDate,@RequestParam("endDate")LocalDateTime endDate) {

		try {
			log.info("request for fetching video logs started");
			BaseResponse response = videoService.fetchVideoLogs(startDate, endDate);
			log.info("request for fetching video logs completed");
			return response;
		} catch (ATMException e) {
			throw new ATMException("exception occured while fetching camera data", e.getHttpStatus());
		} catch (Exception e) {
			throw new ATMException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

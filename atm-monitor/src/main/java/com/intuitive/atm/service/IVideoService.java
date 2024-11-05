package com.intuitive.atm.service;

import java.time.LocalDateTime;

import com.intuitive.atm.dto.BaseResponse;

public interface IVideoService {
	
	BaseResponse fetchVideoLogs(LocalDateTime start,LocalDateTime end);

}

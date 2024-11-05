package com.intuitive.atm.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.entity.BaseEntity;


import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VideoLogsResponse extends BaseResponse {
	
	private List<VideoLogsDetailsDto> videoLogs;

}

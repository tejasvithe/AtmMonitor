package com.intuitive.atm.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.intuitive.atm.enums.DocumentType;
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
public class VideoLogsDetailsDto {

	private DocumentType documentType;

	private String documentUrl;

	private Long atmId;

	private String deviceId;
	
	private LocalDateTime createdDate;

}

package com.intuitive.atm.entity;


import com.intuitive.atm.enums.DocumentType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="video_logs")
public class VideoLogsEntity extends BaseEntity {
		
	private DocumentType documentType;
	
	private String documentUrl;
	
	private Long atmId;
	
	private String deviceId;

}

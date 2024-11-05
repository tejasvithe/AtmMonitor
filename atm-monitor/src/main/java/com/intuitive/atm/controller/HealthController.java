package com.intuitive.atm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("health")
@Slf4j
public class HealthController {

	@GetMapping
	public String healthCheck() {
		
		log.info("health check call");

		return "Application is running";
	}

}

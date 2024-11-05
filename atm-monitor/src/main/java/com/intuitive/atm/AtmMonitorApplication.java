package com.intuitive.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.google.gson.Gson;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class AtmMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmMonitorApplication.class, args);
	}
	
	@Bean
    public Gson getGson() {
        return new Gson();
    }

}

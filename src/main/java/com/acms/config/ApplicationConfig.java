package com.acms.config;

import javax.ws.rs.ext.ExceptionMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acms.exception.handler.ExceptionHandler;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ExceptionMapper<Exception> exceptionProvider() {
		return new ExceptionHandler();
	}
}

package com.example.SpringbootApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SpringbootApp.mapper.MapperHelper;

@Configuration
public class ConfigurationBeans {

	@Bean
	public MapperHelper mapper() {
		return MapperHelper.INSTANCE;
	}
	
}

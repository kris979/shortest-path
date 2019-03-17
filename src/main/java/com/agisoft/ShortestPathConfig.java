package com.agisoft;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/shortestpath.properties")
public class ShortestPathConfig {
	
	@Value("${board.size}")
	private Integer boardSize;

    @Bean
    public Integer size() {
    	return boardSize;
    }
}

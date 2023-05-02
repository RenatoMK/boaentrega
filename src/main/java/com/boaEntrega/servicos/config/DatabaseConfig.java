package com.boaEntrega.servicos.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
	
	@Bean
	public DataSource dataSource() throws IOException{
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("org.h2.Driver");
		config.setJdbcUrl("jdbc:h2:mem:boaEntrega_mem");
		config.setUsername("sa");
		config.setPassword("");
		return new HikariDataSource(config);
	}

}

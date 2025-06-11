package com.velogexport.nicesqlpractice.statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PrepareStatementConfiguration {
	@Autowired
	private JdbcTemplate jdbcTemplate;


}

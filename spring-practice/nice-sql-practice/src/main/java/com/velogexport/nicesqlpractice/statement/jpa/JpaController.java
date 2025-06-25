package com.velogexport.nicesqlpractice.statement.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JpaController {
	private final HikariDataSource dataSource;
	private final PrepareStatementService prepareStatementService;

	@GetMapping("/config")
	public Map<String, Object> checkConfig() {
		Map<String, Object> config = new HashMap<>();
		Properties props = dataSource.getDataSourceProperties();

		config.put("cachePrepStmts", props.getProperty("cachePrepStmts"));
		config.put("prepStmtCacheSize", props.getProperty("prepStmtCacheSize"));
		config.put("useServerPrepStmts", props.getProperty("useServerPrepStmts"));

		return config;
	}


	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	void activate() {
		prepareStatementService.act();
	}

}

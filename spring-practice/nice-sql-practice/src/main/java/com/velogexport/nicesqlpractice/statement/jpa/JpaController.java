package com.velogexport.nicesqlpractice.statement.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JpaController {
	private final PrepareStatementService prepareStatementService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	void activate() {
		prepareStatementService.act();
	}
}

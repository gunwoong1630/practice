package com.velogexport.nicesqlpractice.statement.jpa;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrepareStatementService {
	private final PrepareStatementRepository prepareStatementRepository;

	void act() {
		prepareStatementRepository.findAllById(0L);
	}

	void acg2() {
		prepareStatementRepository.count();
	}
}

package com.velogexport.nicesqlpractice.statement.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrepareStatementService {
	private final PrepareStatementRepository prepareStatementRepository;

	@Transactional
	void act() {
		prepareStatementRepository.findAllById(1L);  // 캐시 저장
		prepareStatementRepository.findAllById(2L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!
		prepareStatementRepository.findAllById(3L);  // 캐시 재사용!

	}
}

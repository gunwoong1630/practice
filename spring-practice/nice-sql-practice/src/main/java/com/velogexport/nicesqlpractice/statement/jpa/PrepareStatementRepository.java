package com.velogexport.nicesqlpractice.statement.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepareStatementRepository extends JpaRepository<PrepareStatementEntity, Long> {
	@Query("select p from PrepareStatementEntity p where p.id = :id")
	List<PrepareStatementEntity> findAllById(@Param(value = "id") Long id);

}

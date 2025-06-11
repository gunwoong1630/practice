package com.example.backend.global

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class TimeStamp {
    @CreatedDate
    lateinit var createAt: LocalDateTime
    @LastModifiedDate
    lateinit var updateAt: LocalDateTime
}
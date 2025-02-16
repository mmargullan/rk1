package com.rk1.margulan.repository

import com.rk1.margulan.model.Priority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PriorityRepository : JpaRepository<Priority, Long> {
    fun findByUserId(userId: Long): List<Priority>
}
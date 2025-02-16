package com.rk1.margulan.repository

import com.rk1.margulan.model.Stat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StatRepository : JpaRepository<Stat, Long> {
    fun findByUserId(userId: Long): Stat
}
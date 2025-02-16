package com.rk1.margulan.repository

import com.rk1.margulan.model.Activity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityRepository : JpaRepository<Activity, Long> {
    fun findByUserId(userId: Long): Activity
}
package com.rk1.margulan.repository

import com.rk1.margulan.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, Long> {
    fun findByUserId(userId: Long): List<Task>
    fun findByCategoryId(categoryId: Long): List<Task>
    fun findByPriorityId(priorityId: Long): List<Task>
}
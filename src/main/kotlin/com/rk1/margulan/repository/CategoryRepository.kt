package com.rk1.margulan.repository

import com.rk1.margulan.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {
    fun findByUserId(userId: Long): List<Category>
}
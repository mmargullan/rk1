package com.rk1.margulan.repository

import com.rk1.margulan.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User
    fun findByUsername(username: String): User
}
package com.rk1.margulan.service

import com.rk1.margulan.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.security.core.authority.SimpleGrantedAuthority as Authority
import org.springframework.security.core.userdetails.User as SpringSecurityUser

@Component
class CustomUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
        return SpringSecurityUser(
            user.username ?: throw IllegalArgumentException("Username cannot be null"),
            user.password ?: throw IllegalArgumentException("Password cannot be null"),
            user.roles?.map { Authority(it.name) } ?: emptyList()
        )
    }

}
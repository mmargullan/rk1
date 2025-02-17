package com.rk1.margulan.service

import com.rk1.margulan.config.JwtTokenUtil
import com.rk1.margulan.model.Dto.LoginUser
import com.rk1.margulan.repository.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtTokenUtil: JwtTokenUtil,
    private val authenticationManager: AuthenticationManager,
    private val customUserDetailsService: CustomUserDetailsService
) {

    fun login(loginUser: LoginUser): String {
        if (!loginUser.username.isNullOrEmpty() && !loginUser.password.isNullOrEmpty()) {
            val userDetails = customUserDetailsService.loadUserByUsername(loginUser.username!!)
            val authToken = UsernamePasswordAuthenticationToken(loginUser.username, loginUser.password, userDetails.authorities)
            authenticationManager.authenticate(authToken)

            val user = userRepository.findByUsername(loginUser.username!!)

            return jwtTokenUtil.generateToken(userDetails)
        }
        return "Not authorized"
    }


}
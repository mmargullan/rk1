package com.rk1.margulan.config

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthorizationFilter(
    private val jwtTokenUtil: JwtTokenUtil
): OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        val requestTokenHeader =request.getHeader("Authorization")
        val path = request.requestURI

        if (!path.equals("/user/login")){
            var username: String? =null
            var jwtToken: String? =null
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                jwtToken = requestTokenHeader.substring(7)
                try {
                    username = jwtTokenUtil.getUsernameFromToken(jwtToken)
                } catch (e: Exception) {
                    println(e.message)
                }
            } else if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")){
                println("Not authorized")
            }
            if (username != null && SecurityContextHolder.getContext().authentication == null) {
                if (jwtTokenUtil.validateToken(jwtToken!!)) {
                    val roles = listOf(jwtTokenUtil.getRolesFromToken(token = jwtToken))
                    val authorities = roles.map { SimpleGrantedAuthority(it) }
                    val authToken = UsernamePasswordAuthenticationToken(username, null, authorities)
                    authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                    SecurityContextHolder.getContext().authentication = authToken
                }
            }
        }
        filterChain.doFilter(request, response)
    }

}
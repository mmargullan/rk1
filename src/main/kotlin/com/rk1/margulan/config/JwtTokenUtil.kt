package com.rk1.margulan.config

import com.rk1.margulan.model.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.io.Serializable
import java.util.*
import java.util.function.Function

@Component
class JwtTokenUtil: Serializable {

    private val jwtSecret = "JwtSecretRk1"
    private val jwtValidationTime = 43200000

    fun generateToken(userDetails: UserDetails): String {
        return Jwts.builder()
            .claim("username", userDetails.username)
            .claim("password", userDetails.password)
            .claim("roles", userDetails.authorities)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + jwtValidationTime))
            .signWith(SignatureAlgorithm.HS256, jwtSecret)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun getAllClaimsFromToken(token: String?): Claims {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body
    }

    fun <T> getClaimFromToken(token: String?, claimsResolver: Function<Claims, T>): T {
        val claims = getAllClaimsFromToken(token)
        return claimsResolver.apply(claims)
    }

    fun getUsernameFromToken(token: String?): String {
        return getClaimFromToken(token) { obj: Claims -> obj["username"].toString() }
    }

    fun getRolesFromToken(token: String?): String {
        return getClaimFromToken(token) { obj: Claims -> obj["roles"].toString() }
    }

}
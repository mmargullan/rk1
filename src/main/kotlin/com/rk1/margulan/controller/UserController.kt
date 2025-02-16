package com.rk1.margulan.controller

import com.rk1.margulan.model.User
import com.rk1.margulan.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    val userRepository: UserRepository
) {

    @GetMapping("/getAll")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

}
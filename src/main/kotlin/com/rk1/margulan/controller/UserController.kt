package com.rk1.margulan.controller

import com.rk1.margulan.model.Dto.LoginUser
import com.rk1.margulan.model.User
import com.rk1.margulan.repository.UserRepository
import com.rk1.margulan.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody loginUser: LoginUser): String {
        return userService.login(loginUser)
    }

    @GetMapping("/getAll")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

}
package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.user.LoginRequest;
import com.workintech.ecommerce.dto.user.UserRequest;
import com.workintech.ecommerce.dto.user.UserResponse;
import com.workintech.ecommerce.entity.user.User;
import com.workintech.ecommerce.service.user.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest registerUser) {
        return authenticationService.register(registerUser.name(), registerUser.email(), registerUser.password());
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }
}

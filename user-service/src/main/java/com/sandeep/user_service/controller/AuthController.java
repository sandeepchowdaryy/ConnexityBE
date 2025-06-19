package com.sandeep.user_service.controller;

import com.sandeep.user_service.dto.LoginRequestDto;
import com.sandeep.user_service.dto.SignupRequestDto;
import com.sandeep.user_service.service.AuthService;
import com.sandeep.user_service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        UserDto userDto = authService.signUp(signupRequestDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        String token = authService.login(loginRequestDto);
        return ResponseEntity.ok(token);
    }
    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getAllusers(@PathVariable Long userId) {
        UserDto user = authService.getAll(userId);
        return ResponseEntity.ok(user);
    }
}

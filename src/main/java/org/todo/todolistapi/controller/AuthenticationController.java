package org.todo.todolistapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todo.todolistapi.model.ApiResponse;
import org.todo.todolistapi.model.auth.AuthenticationResponse;
import org.todo.todolistapi.model.auth.LoginRequest;
import org.todo.todolistapi.model.auth.RegisterRequest;
import org.todo.todolistapi.service.AuthenticationService;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationService authService;

    @Autowired
    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        AuthenticationResponse response = authService.register(request);
        return ResponseEntity.ok(new ApiResponse("User registered successfully", response));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        AuthenticationResponse response = authService.login(request);
        return ResponseEntity.ok(new ApiResponse("Login successful", response));
    }
}

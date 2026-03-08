package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.AuthResponse;
import org.example.dto.LoginRequest;
import org.example.dto.RegisterRequest;
import org.example.service.AuthService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest req){
        service.register(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req){
        return service.login(req);
    }

}
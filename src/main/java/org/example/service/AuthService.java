package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthResponse;
import org.example.dto.LoginRequest;
import org.example.dto.RegisterRequest;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public void register(RegisterRequest req){

        User user= User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .role(req.getRole())
                .build();

        repo.save(user);

    }

    public AuthResponse login(LoginRequest req){

        User user=repo.findByEmail(req.getEmail()).orElseThrow();

        if(!encoder.matches(req.getPassword(),user.getPassword()))
            throw new RuntimeException();

        String token=jwt.generateToken(user.getEmail());

        return new AuthResponse(token);

    }

}

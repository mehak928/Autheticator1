package org.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public")
    public String publicApi(){
        return "Public";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user(){
        return "User Content";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "Admin Content";
    }

}
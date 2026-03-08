package org.example.dto;

import lombok.Data;
import org.example.entity.Role;

@Data
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private Role role;

}
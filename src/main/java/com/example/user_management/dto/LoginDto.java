package com.example.user_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank(message = "Username or email can not be Empty")
    private String usernameOrEmail;
    @NotBlank(message = "Password can not be Empty")
    private String password;
}

package com.example.user_management.service;

import com.example.user_management.dto.LoginDto;
import com.example.user_management.dto.RegisterDto;

public interface AuthService {
    String Register(RegisterDto registerDto);
    String Login(LoginDto loginDto);
}

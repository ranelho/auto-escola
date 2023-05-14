package com.rlti.autoescola.security.auth.service;

import com.rlti.autoescola.security.auth.api.AuthenticationRequest;
import com.rlti.autoescola.security.auth.api.RegisterRequest;
import com.rlti.autoescola.security.auth.api.UpdatePasswordRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {
    Object register(RegisterRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
    Object authenticate(AuthenticationRequest request, HttpServletRequest httpServletRequest);
    void updatePassword(String email, UpdatePasswordRequest request);
}

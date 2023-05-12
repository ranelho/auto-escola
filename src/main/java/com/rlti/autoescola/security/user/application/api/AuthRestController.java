package com.rlti.autoescola.security.user.application.api;

import com.rlti.autoescola.security.user.application.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AuthRestController implements AuthApi {
    private final AuthService authService;

    @Override
    public AuthentificationResponse register(RegisterRequest request) {
        log.info("[inicia] AuthRestController - register");
        AuthentificationResponse response = authService.register(request);
        log.info("[finaliza] AuthRestController - register");
        return response;
    }

    @Override
    public AuthentificationResponse authenticate(AuthentificationRequest request) {
        log.info("[inicia] AuthRestController - register");
        AuthentificationResponse response = authService.authenticate(request);
        log.info("[finaliza] AuthRestController - register");
        return response;
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("[inicia] AuthRestController - refreshToken");
        authService.refreshToken(request, response);
        log.info("[finaliza] AuthRestController - refreshToken");
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        log.info("[inicia] AuthRestController - logout");
        authService.logout(request, response);
        log.info("[finaliza] AuthRestController - logout");
    }
}

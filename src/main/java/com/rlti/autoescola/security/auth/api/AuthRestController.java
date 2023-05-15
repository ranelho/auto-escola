package com.rlti.autoescola.security.auth.api;

import com.rlti.autoescola.security.auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AuthRestController implements AuthApi {
    private final AuthService authService;

    @Override
    public ResponseEntity<AuthenticationResponse> register(RegisterRequest request) {
        log.info("[inicia] AuthRestController.register");
        AuthenticationResponse response = (AuthenticationResponse) authService.register(request);
        log.info("[finaliza] AuthRestController.register");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request, HttpServletRequest httpServletRequest) {
        log.info("[inicia] AuthRestController.authenticate");
        AuthenticationResponse response = (AuthenticationResponse) authService.authenticate(request, httpServletRequest);
        log.info("[finaliza] AuthRestController.authenticate");
        return ResponseEntity.ok(response);
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("[inicia] AuthRestController.refreshToken");
        authService.refreshToken(request, response);
        log.info("[finaliza] AuthRestController.refreshToken");
    }

    @Override
    public void updatePasswordUser(String token, UpdatePasswordRequest request) {
        log.info("[inicia] AuthRestController.updatePasswordUser");
        authService.updatePasswordUser(token, request);
        log.info("[finaliza] AuthRestController.updatePasswordUser");
    }

    @Override
    public void updatePassword(String email, UpdatePasswordRequest request) {
        log.info("[inicia] AuthRestController.updatePassword");
        authService.updatePassword(email, request);
        log.info("[finaliza] AuthRestController.updatePassword");
    }
}

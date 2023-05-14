package com.rlti.autoescola.security.auth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.security.auth.api.AuthenticationRequest;
import com.rlti.autoescola.security.auth.api.AuthenticationResponse;
import com.rlti.autoescola.security.auth.api.RegisterRequest;
import com.rlti.autoescola.security.auth.api.UpdatePasswordRequest;
import com.rlti.autoescola.security.config.JwtService;
import com.rlti.autoescola.security.infra.AccessLogRepository;
import com.rlti.autoescola.security.infra.UserRepository;
import com.rlti.autoescola.security.token.Token;
import com.rlti.autoescola.security.token.TokenRepository;
import com.rlti.autoescola.security.token.TokenType;
import com.rlti.autoescola.security.user.AccessLog;
import com.rlti.autoescola.security.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthApplicationService implements AuthService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AccessLogRepository accessLogRepository;

    @Override
    public Object register(RegisterRequest request) {
        log.info("[inicia] AuthApplicationService.register");
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        log.info("[finaliza] AuthApplicationService.register");
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public Object authenticate(AuthenticationRequest request, HttpServletRequest httpServletRequest) {
        log.info("[inicia] AuthApplicationService.authenticate");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        log.info("[finaliza] AuthApplicationService.authenticate");
        accessLogRepository.save(new AccessLog(user, httpServletRequest));
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void updatePassword(String email, UpdatePasswordRequest request) {
        log.info("[inicia] AuthApplicationService.updatePassword");
        var user = repository.findByEmail(email)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        log.info("[finaliza] AuthApplicationService.updatePassword");
    }

    private void saveUserToken(User user, String jwtToken) {
        log.info("[inicia] AuthApplicationService.saveUserToken");
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
        log.info("[finaliza] AuthApplicationService.saveUserToken");
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getIdUser());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("[inicia] AuthApplicationService.refreshToken");
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {  return;  }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
        log.info("[finaliza] AuthApplicationService.refreshToken");
    }
}

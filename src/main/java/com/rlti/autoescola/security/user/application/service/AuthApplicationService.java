package com.rlti.autoescola.security.user.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rlti.autoescola.security.config.service.JwtService;
import com.rlti.autoescola.security.token.application.service.TokenService;
import com.rlti.autoescola.security.user.application.api.AuthentificationRequest;
import com.rlti.autoescola.security.user.application.api.AuthentificationResponse;
import com.rlti.autoescola.security.user.application.api.RegisterRequest;
import com.rlti.autoescola.security.user.application.repository.UserRepository;
import com.rlti.autoescola.security.user.domain.User;
import com.rlti.autoescola.security.user.infra.UserSpringDataJPARepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthApplicationService implements AuthService {

    private final UserSpringDataJPARepository userSpringDataJPARepository;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthentificationResponse register(RegisterRequest request) {
        log.info("[inicia]  AuthApplicationService - register");
        User user = userRepository.salva(new User(request));
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateToken(user);
        tokenService.saveToken(user, jwtToken);
        log.info("[fim]  AuthApplicationService - register");
        return AuthentificationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
    }

    @Override
    public AuthentificationResponse authenticate(AuthentificationRequest request) {
        log.info("[inicia]  AuthApplicationService - authenticate");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        tokenService.revokeAllUserTokens(user,jwtToken);
        tokenService.saveToken(user, jwtToken);
        log.info("[fim]  AuthApplicationService - authenticate");
        return AuthentificationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
    }
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        log.info("[inicia]  AuthApplicationService - logout");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        log.info("[fim]  AuthApplicationService - logout");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("[inicia]  AuthApplicationService - refreshToken");
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.userSpringDataJPARepository.findByEmail(userEmail)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                tokenService.revokeAllUserTokens(user,refreshToken);
                tokenService.saveToken(user, accessToken);
                var authResponse = AuthentificationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
        log.info("[fim]  AuthApplicationService - refreshToken");
    }
}

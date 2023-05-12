package com.rlti.autoescola.security.config;

import com.rlti.autoescola.security.config.service.JwtService;
import com.rlti.autoescola.security.token.domain.Token;
import com.rlti.autoescola.security.token.infra.TokenSpringJPARepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthentificationFilter extends OncePerRequestFilter {
    final JwtService jwtService;
    final UserDetailsService userDetailsService;
    private final TokenSpringJPARepository tokenSpringJPARepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("Test 1 ");

        String jwt = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(jwt);
        System.out.println(jwt);
        System.out.println("Test 2 ");
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("Test 3 ");
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            boolean isTokenValid = tokenSpringJPARepository.findByToken(jwt)
                    .map(t -> t.isExpired()  )
                    .orElse(false);

            System.out.println(isTokenValid);
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                System.out.println("Test 4 ");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("Test 5 "+authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    public boolean isTokenValid(String token) {
        Optional<Token> optionalToken = tokenSpringJPARepository.findByToken(token);
        if (optionalToken.isPresent()) {
            Token t = optionalToken.get();
            return !t.isExpired() && !t.isRevoked();
        }
        return false;
    }
}
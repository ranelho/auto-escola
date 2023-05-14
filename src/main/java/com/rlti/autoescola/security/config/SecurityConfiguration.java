package com.rlti.autoescola.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.rlti.autoescola.security.user.Role.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers(
                        "/v1/auth/**",
                        "/public/swagger-resources",
                        "/public/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/public/swagger-ui/**",
                        "/webjars/**",
                        "/public/swagger-ui.html"
                ).permitAll()
                //ACESSO EXCLUSIVO AO ADMIN
                .requestMatchers("/v1/relatorios/**").hasRole(ADMIN.name())
                .requestMatchers("/v1/fluxo-de-caixa/**").hasRole(ADMIN.name())
                .requestMatchers("/v1/servicos/**").hasRole(ADMIN.name())
                //ACESSO EXCLUSIVO AO MANAGER E ADMIN
                .requestMatchers("/v1/manutencoes/**").hasAnyRole(MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/veiculos/**").hasAnyRole(MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/clientes/**").hasAnyRole(MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/empresas/**").hasAnyRole(MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/exames/**").hasAnyRole(MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/instrutores/**").hasAnyRole(MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/laudos/**").hasAnyRole(MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/pagamentos/**").hasAnyRole(MANAGER.name(), ADMIN.name())
                //ACESSO DE TODOS
                .requestMatchers("/v1/contatos/**").hasAnyRole(USER.name(), MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/agendas/**").hasAnyRole(USER.name(), MANAGER.name(), ADMIN.name())
                .requestMatchers("/v1/orcamentos/**").hasAnyRole(USER.name(), MANAGER.name(), ADMIN.name())

                .anyRequest().authenticated()
            .and()
              .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/v1/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        ;
        return http.build();
    }
}

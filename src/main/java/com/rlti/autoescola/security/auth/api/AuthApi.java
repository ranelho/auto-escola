package com.rlti.autoescola.security.auth.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "Authenticate", description = "Authenticate APIs")
@RequestMapping("/v1/auth")
public interface AuthApi {

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request);

    @PostMapping("/authenticate")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request, HttpServletRequest httpServletRequest);

    @PostMapping("/refresh-token")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

    @PutMapping("/update-password/{email}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updatePassword(@PathVariable String email, @RequestBody UpdatePasswordRequest request);
}

package com.rlti.autoescola.security.token.application.service;

import com.rlti.autoescola.security.user.domain.User;

public interface TokenService {
    void saveToken(User user, String jwtToken);
    void revokeAllUserTokens(User user, String jwtToken);
}

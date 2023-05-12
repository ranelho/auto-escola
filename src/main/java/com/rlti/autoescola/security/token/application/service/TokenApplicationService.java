package com.rlti.autoescola.security.token.application.service;

import com.rlti.autoescola.security.token.application.repository.TokenRepository;
import com.rlti.autoescola.security.token.domain.Token;
import com.rlti.autoescola.security.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TokenApplicationService implements TokenService {
    private final TokenRepository tokenRepository;

    @Override
    public void saveToken(User user, String jwtToken) {
        log.info("[inicia] TokenApplicationService - saveToken");
        tokenRepository.salva(new Token(user, jwtToken));
        log.info("[finaliza] TokenApplicationService - saveToken");
    }

    @Override
    public void revokeAllUserTokens(User user, String jwtToken) {
        log.info("[inicia]  AuthApplicationService - revokeAllUserTokens");
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
            token.setToken("jwtToken");
        });
        tokenRepository.saveAll(validUserTokens);
        log.info("[fim]  AuthApplicationService - revokeAllUserTokens");
    }

}

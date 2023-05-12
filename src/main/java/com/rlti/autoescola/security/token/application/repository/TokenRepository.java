package com.rlti.autoescola.security.token.application.repository;

import com.rlti.autoescola.security.token.domain.Token;

import java.util.List;
import java.util.UUID;

public interface TokenRepository {
    void salva(Token token);
    List<Token> findAllValidTokenByUser(UUID id);
    void saveAll(List<Token> validUserTokens);
}

package com.rlti.autoescola.security.token.infra;

import com.rlti.autoescola.security.token.application.repository.TokenRepository;
import com.rlti.autoescola.security.token.domain.Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class TokenInfraRepository implements TokenRepository {
    private final TokenSpringJPARepository tokenSpringJPARepository;

    @Override
    public void salva(Token token) {
        log.info("[inicia] TokenInfraRepository - salva ");
        tokenSpringJPARepository.save(token);
        log.info("[finaliza] TokenInfraRepository - salva");
    }

    @Override
    public List<Token> findAllValidTokenByUser(UUID id) {
        log.info("[inicia] TokenInfraRepository - findAllValidTokenByUser ");
        List<Token> list = tokenSpringJPARepository.findAllValidTokenByUser(id);
        log.info("[finaliza] TokenInfraRepository - findAllValidTokenByUser ");
        return list;
    }

    @Override
    public void saveAll(List<Token> validUserTokens) {
        log.info("[inicia] TokenInfraRepository - saveAll ");
        tokenSpringJPARepository.saveAll(validUserTokens);
        log.info("[finaliza] TokenInfraRepository - saveAll ");
    }
}

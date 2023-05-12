package com.rlti.autoescola.security.user.infra;

import com.rlti.autoescola.security.user.application.repository.UserRepository;
import com.rlti.autoescola.security.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UserInfraRepository implements UserRepository {
    private final UserSpringDataJPARepository userSpringDataJPARepository;
    @Override
    public User salva(User user) {
        log.info("[inicia] UserInfraRepository - salva");
        userSpringDataJPARepository.save(user);
        log.info("[finaliza] UserInfraRepository - salva");
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.info("[inicia] UserInfraRepository - findByEmail");
        Optional<User> optional = userSpringDataJPARepository.findByEmail(email);
        log.info("[finaliza] UserInfraRepository - findByEmail");
        return optional;
    }
}

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
    private final UserSpringDataJpaRepository userSpringDataJpaRepository;

    @Override
    public User save(User user) {
        log.info("[inicio] UserInfraRepository.save");
        userSpringDataJpaRepository.save(user);
        log.info("[inicio] UserInfraRepository.save");
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.info("[inicio] UserInfraRepository.findByEmail");
        Optional<User> user = userSpringDataJpaRepository.findByEmail(email);
        log.info("[inicio] UserInfraRepository.findByEmail");
        return user;
    }
}

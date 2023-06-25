package com.rlti.autoescola.security.user.infra;

import com.rlti.autoescola.security.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserSpringDataJpaRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}

package com.rlti.autoescola.security.user.application.repository;

import com.rlti.autoescola.security.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByEmail(String email);
}

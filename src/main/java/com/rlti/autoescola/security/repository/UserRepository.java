package com.rlti.autoescola.security.repository;

import com.rlti.autoescola.security.user.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByEmail(String email);
}

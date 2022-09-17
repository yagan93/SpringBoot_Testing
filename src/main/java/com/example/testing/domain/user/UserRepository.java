package com.example.testing.domain.user;

import com.example.testing.core.generic.ExtendedRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ExtendedRepository<User> {
    Optional<User> findByEmail(String email);
}

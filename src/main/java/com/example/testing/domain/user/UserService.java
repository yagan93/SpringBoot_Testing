package com.example.testing.domain.user;

import com.example.testing.core.generic.ExtendedService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, ExtendedService<User> {
    User register(User user);
}

package com.example.testing.domain.role;

import com.example.testing.core.generic.ExtendedRepository;
import com.example.testing.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService {

    @Autowired
    public RoleServiceImpl(ExtendedRepository<Role> repository, Logger logger) {
        super(repository, logger);
    }
}

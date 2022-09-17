package com.example.testing.domain.orderingposition;

import com.example.testing.core.generic.ExtendedRepository;
import com.example.testing.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPositionServiceImpl extends ExtendedServiceImpl<OrderingPosition> implements OrderingPositionService {

    @Autowired
    public OrderPositionServiceImpl(ExtendedRepository<OrderingPosition> repository, Logger logger) {
        super(repository, logger);
    }
}

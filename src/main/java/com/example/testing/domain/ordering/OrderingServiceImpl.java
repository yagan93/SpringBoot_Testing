package com.example.testing.domain.ordering;

import com.example.testing.core.generic.ExtendedRepository;
import com.example.testing.core.generic.ExtendedServiceImpl;
import com.example.testing.domain.orderingposition.OrderingPosition;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderingServiceImpl extends ExtendedServiceImpl<Ordering> implements OrderingService {

    @Autowired
    public OrderingServiceImpl(ExtendedRepository<Ordering> repository, Logger logger) {
        super(repository, logger);
    }

    @Override
    @Transactional
    public Ordering save(Ordering ordering) {
        Set<OrderingPosition> detachedPositions = ordering.getOrderingPositions();
        Ordering cachedOrdering = repository.save(ordering.setOrderingPositions(new HashSet<>()));
        cachedOrdering.setOrderingPositions(detachedPositions.stream().map(p -> p.setOrdering(cachedOrdering)).collect(Collectors.toSet()));
        return repository.save(cachedOrdering);
    }

}

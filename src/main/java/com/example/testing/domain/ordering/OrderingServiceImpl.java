package com.example.testing.domain.ordering;

import com.example.testing.domain.orderingposition.OrderingPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderingServiceImpl implements OrderingService {

    private final OrderingRepository orderingRepository;

    @Autowired
    public OrderingServiceImpl(OrderingRepository orderingRepository) {
        this.orderingRepository = orderingRepository;
    }

    @Override
    @Transactional
    public Ordering save(Ordering ordering) {
        Set<OrderingPosition> detachedPositions = ordering.getOrderingPositions();
        Ordering cachedOrdering = orderingRepository.save(ordering.setOrderingPositions(new HashSet<>()));
        cachedOrdering.setOrderingPositions(detachedPositions.stream().map(p -> p.setOrdering(cachedOrdering)).collect(Collectors.toSet()));
        return orderingRepository.save(cachedOrdering);
    }

    @Override
    public List<Ordering> findAll() {
        return orderingRepository.findAll();
    }
}

package com.example.testing.domain.ordering;

import java.util.List;

public interface OrderingService {
    Ordering save(Ordering ordering);

    List<Ordering> findAll();
}

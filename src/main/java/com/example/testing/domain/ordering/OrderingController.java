package com.example.testing.domain.ordering;

import com.example.testing.domain.ordering.dto.OrderingDTO;
import com.example.testing.domain.ordering.dto.OrderingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderings")
public class OrderingController {

    private final OrderingService orderingService;
    private final OrderingMapper orderingMapper;

    @Autowired
    public OrderingController(OrderingService orderingService, OrderingMapper orderingMapper) {
        this.orderingService = orderingService;
        this.orderingMapper = orderingMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderingDTO>> retrieveAll() {
        return new ResponseEntity<>(orderingMapper.toDTOs(orderingService.findAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderingDTO> create(@RequestBody OrderingDTO orderingDTO) {
        Ordering ordering = orderingService.save(orderingMapper.fromDTO(orderingDTO));
        return new ResponseEntity<>(orderingMapper.toDTO(ordering), HttpStatus.CREATED);
    }

}

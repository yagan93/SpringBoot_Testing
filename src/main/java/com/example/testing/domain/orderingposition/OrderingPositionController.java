package com.example.testing.domain.orderingposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderingPositions")
public class OrderingPositionController {

    private final OrderingPositionService orderingPositionService;

    @Autowired
    public OrderingPositionController(OrderingPositionService orderingPositionService) {
        this.orderingPositionService = orderingPositionService;
    }

    @GetMapping
    public ResponseEntity<List<OrderingPosition>> retrieveAll() {
        return new ResponseEntity<>(orderingPositionService.findAll(), HttpStatus.OK);
    }
}

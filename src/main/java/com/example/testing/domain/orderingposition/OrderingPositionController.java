package com.example.testing.domain.orderingposition;

import com.example.testing.domain.orderingposition.dto.OrderingPositionDTO;
import com.example.testing.domain.orderingposition.dto.OrderingPositionMapper;
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
    private final OrderingPositionMapper orderingPositionMapper;

    @Autowired
    public OrderingPositionController(OrderingPositionService orderingPositionService, OrderingPositionMapper orderingPositionMapper) {
        this.orderingPositionService = orderingPositionService;
        this.orderingPositionMapper = orderingPositionMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderingPositionDTO>> retrieveAll() {
        return new ResponseEntity<>(orderingPositionMapper.toDTOs(orderingPositionService.findAll()), HttpStatus.OK);
    }
}

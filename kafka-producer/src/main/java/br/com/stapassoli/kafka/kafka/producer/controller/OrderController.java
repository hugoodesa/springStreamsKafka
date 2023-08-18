package br.com.stapassoli.kafka.kafka.producer.controller;

import br.com.stapassoli.kafka.kafka.producer.entity.Order;
import br.com.stapassoli.kafka.kafka.producer.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> createOrder (@RequestBody Order order) {
        return this.service.createOrder(order);
    }

}

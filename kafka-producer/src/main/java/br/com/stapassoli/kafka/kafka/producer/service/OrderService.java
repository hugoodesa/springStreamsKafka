package br.com.stapassoli.kafka.kafka.producer.service;

import br.com.stapassoli.kafka.kafka.producer.entity.Order;
import br.com.stapassoli.kafka.kafka.producer.entity.Payment;
import br.com.stapassoli.kafka.kafka.producer.entity.Person;
import br.com.stapassoli.kafka.kafka.producer.repository.OrderRepository;
import br.com.stapassoli.kafka.kafka.producer.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    @Transactional
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order orderSaved = this.repository.save(order);
        return ResponseEntity.ok(orderSaved);
    }

    @Transactional
    public void payOrder(Payment payment) {
        Long idOrder = payment.getIdSale();

        Order order = this.repository.findById(idOrder).orElseThrow(() -> {
            throw new EntityNotFoundException("Order was not found");
        });

        order.setIsPaidOut(true);

        this.repository.save(order);
    }

}

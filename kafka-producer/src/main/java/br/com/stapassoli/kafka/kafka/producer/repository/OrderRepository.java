package br.com.stapassoli.kafka.kafka.producer.repository;

import br.com.stapassoli.kafka.kafka.producer.entity.Order;
import br.com.stapassoli.kafka.kafka.producer.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

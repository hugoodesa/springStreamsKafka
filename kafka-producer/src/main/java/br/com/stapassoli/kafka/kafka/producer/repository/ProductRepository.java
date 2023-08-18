package br.com.stapassoli.kafka.kafka.producer.repository;

import br.com.stapassoli.kafka.kafka.producer.entity.Person;
import br.com.stapassoli.kafka.kafka.producer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

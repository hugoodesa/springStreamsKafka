package br.com.stapassoli.kafka.kafka.producer.repository;

import br.com.stapassoli.kafka.kafka.producer.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

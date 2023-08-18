package br.com.stapassoli.kafka.kafka.producer.service;

import br.com.stapassoli.kafka.kafka.producer.entity.Person;
import br.com.stapassoli.kafka.kafka.producer.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final PersonRepository repository;

    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = this.repository.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    public void sendMessage(String message) {
        this.kafkaTemplate.send("Topic01", message);
    }
}

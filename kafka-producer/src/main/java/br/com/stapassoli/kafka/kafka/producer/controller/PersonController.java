package br.com.stapassoli.kafka.kafka.producer.controller;

import br.com.stapassoli.kafka.kafka.producer.entity.Person;
import br.com.stapassoli.kafka.kafka.producer.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Person> createPerson (@RequestBody Person person) {
        return this.service.createPerson(person);
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    public void sendMessage (@RequestBody String message) {
        this.service.sendMessage(message);
    }

}

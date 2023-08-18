package br.com.stapassoli.kafka.kafka.producer.controller;

import br.com.stapassoli.kafka.kafka.producer.entity.Person;
import br.com.stapassoli.kafka.kafka.producer.entity.Product;
import br.com.stapassoli.kafka.kafka.producer.service.PersonService;
import br.com.stapassoli.kafka.kafka.producer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct (@RequestBody Product product) {
        return this.service.createProduct(product);
    }

}

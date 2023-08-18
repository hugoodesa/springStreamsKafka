package br.com.stapassoli.kafka.kafka.producer.service;

import br.com.stapassoli.kafka.kafka.producer.entity.Product;
import br.com.stapassoli.kafka.kafka.producer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;


    public ResponseEntity<Product> createProduct(Product product) {
        Product savedProduct = this.repository.save(product);
        return ResponseEntity.ok(savedProduct);
    }
}

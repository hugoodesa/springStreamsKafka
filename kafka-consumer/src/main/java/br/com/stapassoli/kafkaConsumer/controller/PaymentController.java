package br.com.stapassoli.kafkaConsumer.controller;

import br.com.stapassoli.kafkaConsumer.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final KafkaTemplate<String, Payment> kafkaTemplate;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void sendPayment(@RequestBody Payment payment) {
        this.kafkaTemplate.send("topicPayment", payment);
    }

}

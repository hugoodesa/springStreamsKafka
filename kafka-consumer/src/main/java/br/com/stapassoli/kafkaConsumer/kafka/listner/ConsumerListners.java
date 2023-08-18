package br.com.stapassoli.kafkaConsumer.kafka.listner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerListners {

    @KafkaListener(topics = "Topic01", groupId = "group-01")
    public void mainListner(String message) {
        log.info("Message {}", message);
    }

}

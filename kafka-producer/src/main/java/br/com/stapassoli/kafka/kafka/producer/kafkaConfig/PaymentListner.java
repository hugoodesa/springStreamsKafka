package br.com.stapassoli.kafka.kafka.producer.kafkaConfig;

import br.com.stapassoli.kafka.kafka.producer.entity.Payment;
import br.com.stapassoli.kafka.kafka.producer.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentListner {

    private final OrderService orderService;

    @KafkaListener(topics = "topicPayment", groupId = "group-01", containerFactory = "paymentKafkaListenerContainerFactory")
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "2",
            autoCreateTopics = "false",
            include = Exception.class)
    public void topicListner(Payment payment) {
        log.info("Payment : {} ", payment);

        this.orderService.payOrder(payment);
    }

}

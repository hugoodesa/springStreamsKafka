package br.com.stapassoli.kafka.kafka.producer.entity;

import lombok.*;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    private Long id;
    private Long idSale;
    private Double valuePayed;

}

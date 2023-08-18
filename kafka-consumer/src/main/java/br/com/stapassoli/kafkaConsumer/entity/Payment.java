package br.com.stapassoli.kafkaConsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    private Long id;
    private Long idSale;
    private Double valuePayed;

}

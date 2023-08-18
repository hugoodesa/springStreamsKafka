package br.com.stapassoli.kafka.kafka.producer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    @Column(name = "id_product")
    private Long idProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

}

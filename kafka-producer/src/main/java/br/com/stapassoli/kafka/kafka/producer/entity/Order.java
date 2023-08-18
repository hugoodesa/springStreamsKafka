package br.com.stapassoli.kafka.kafka.producer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isPaidOut;

    @OneToOne
    @JoinColumn(name = "id_person", insertable = false, updatable = false)
    private Person person;

    @Column(name = "id_person")
    private Long idPerson;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private List<OrderProduct> orderProducts = new ArrayList<>();

}

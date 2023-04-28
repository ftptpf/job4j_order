package ru.job4j.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private int phone;
    private int money;

    @ManyToOne
    @JoinColumn(name = "card_id", foreignKey = @ForeignKey(name = "CARD_ID_FK"))
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> order = new ArrayList<>();
}

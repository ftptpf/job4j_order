package ru.job4j.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
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

    @NotBlank(message = "Name can't be null or whitespace!")
    private String name;

    @NotNull(message = "Phone number can't be null!")
    @PositiveOrZero(message = "Phone number must be a positive number or 0!")
    private int phone;

    @NotNull(message = "Money quantity can't be null!")
    @PositiveOrZero(message = "Money quantity must be a positive number or 0!")
    private int money;

    @ManyToOne
    @JoinColumn(name = "card_id", foreignKey = @ForeignKey(name = "CARD_ID_FK"))
    private Card card;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setCustomer(null);
    }
}

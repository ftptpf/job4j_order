package ru.job4j.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotBlank(message = "Description can't be null or whitespace!")
    private String description;

    @NotNull(message = "Order cost can't be null!")
    @PositiveOrZero(message = "Order cost must be a positive number or 0!")
    private int cost;

    private boolean status;

    @NotNull(message = "Dish id can't be null!")
    @PositiveOrZero(message = "Dish id must be a positive number or 0!")
    private int dishId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}

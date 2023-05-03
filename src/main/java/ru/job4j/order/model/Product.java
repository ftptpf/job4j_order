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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotBlank(message = "Product name can't be null or whitespace!")
    private String name;

    @NotNull(message = "Product cost can't be null!")
    @PositiveOrZero(message = "Product cost must be a positive number or 0!")
    private int cost;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

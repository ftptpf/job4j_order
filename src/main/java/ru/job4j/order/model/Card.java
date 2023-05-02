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
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotBlank(message = "Card name can't be null or whitespace!")
    private String name;

    @NotNull(message = "Card discount can't be null!")
    @PositiveOrZero(message = "Discount must be a positive number or 0!")
    private int discount;

    @NotNull(message = "Card cost can't be null!")
    @PositiveOrZero(message = "Card cost must be a positive number or 0!")
    private int cost;
}

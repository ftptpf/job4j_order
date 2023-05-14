package ru.job4j.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.order.model.Dish;
import ru.job4j.order.model.Order;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    @NotNull(message = "Order can't be null!")
    private Order order;

    @NotNull(message = "Dish can't be null!")
    private Dish dish;

}

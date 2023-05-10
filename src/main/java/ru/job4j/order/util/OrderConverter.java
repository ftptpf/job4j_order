package ru.job4j.order.util;

import lombok.experimental.UtilityClass;
import ru.job4j.order.dto.OrderDto;
import ru.job4j.order.model.Order;

@UtilityClass
public class OrderConverter {

    public Order convert(OrderDto orderDto) {
        Order order = new Order();
        order.setDescription(orderDto.getDescription());
        order.setStatus(false);
        order.setCustomer(orderDto.getCustomer());
        /**
         * TODO
         * set products
         * count and set cost
         */
        return order;
    }

}

package ru.job4j.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.order.model.Customer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    @NotBlank(message = "Description can't be null or whitespace!")
    private String description;

    @NotNull(message = "Customer can't be null!")
    private Customer customer;

    @NotNull(message = "Products can't be null!")
    private List<ProductDto> products;

}

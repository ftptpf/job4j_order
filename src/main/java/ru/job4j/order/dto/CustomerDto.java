package ru.job4j.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotBlank(message = "Name can't be null or whitespace!")
    private String name;

    @NotNull(message = "Phone number can't be null!")
    @PositiveOrZero(message = "Phone number must be a positive number or 0!")
    private int phone;
}

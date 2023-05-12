package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.order.model.Dish;
import ru.job4j.order.service.DishService;

@RestController
@RequestMapping("/api/v1/dish")
@AllArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping("/{id}")
    public Dish findById(@PathVariable int id) {
        return dishService.findById(id);
    }

}

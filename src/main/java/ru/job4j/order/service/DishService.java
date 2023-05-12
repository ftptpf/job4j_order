package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Dish;
import ru.job4j.order.repository.DishRepository;

@Service
@AllArgsConstructor
public class DishService {

    private DishRepository dishRepository;

    public Dish findById(int id) {
        return dishRepository.findById(id);
    }
}

package ru.job4j.order.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.order.model.Dish;

@Repository
public class DishRepository {

    @Value("${api-url}")
    private String url;

    private final RestTemplate client;

    public DishRepository(RestTemplate client) {
        this.client = client;
    }

    public Dish findById(int id) {
        return client.getForEntity(
                String.format("%s/api/v1/dish/%s", url, id), Dish.class).getBody();
    }

}

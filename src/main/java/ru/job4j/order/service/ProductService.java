package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Product;
import ru.job4j.order.repository.ProductRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    /**
     * TODO
     * change to array id
     */
    public int sum(int id) {
        return productRepository.sum(id);
    }

}

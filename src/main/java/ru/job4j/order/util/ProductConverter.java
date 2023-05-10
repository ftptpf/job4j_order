package ru.job4j.order.util;

import lombok.experimental.UtilityClass;
import ru.job4j.order.dto.ProductDto;
import ru.job4j.order.model.Product;
import ru.job4j.order.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ProductConverter {

    private ProductService productService;

    List<Product> convert(List<ProductDto> productDtoList) {
        List<Product> list = new ArrayList<>();
        for (ProductDto productDto : productDtoList) {
            Product product = productService.findById(productDto.getId()).orElseThrow();
            list.add(product);
        }
        return list;
    }

}

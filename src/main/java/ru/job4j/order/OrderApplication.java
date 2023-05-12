package ru.job4j.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
        System.out.println("REST API Order service ready for work!");
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

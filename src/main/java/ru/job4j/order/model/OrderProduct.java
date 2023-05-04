package ru.job4j.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders_products")
public class OrderProduct implements Serializable {

    @Id
    @ManyToOne
    private Order order;

    @Id
    @ManyToOne
    private Product product;
}

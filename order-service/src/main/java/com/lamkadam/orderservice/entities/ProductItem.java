package com.lamkadam.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lamkadam.orderservice.model.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter @ToString
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private double price;
    private int quantity;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;
    @Transient
    private Product product;
}

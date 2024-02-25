package com.lamkadam.orderservice.entities;

import com.lamkadam.orderservice.enums.OrderState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "ORDERS")
public class Order {

 @Id
 private String id;

 private LocalDate date;

 @Enumerated(EnumType.STRING)
 private OrderState state ;

 @OneToMany(mappedBy = "order")
 private List<ProductItem> productItems;

}

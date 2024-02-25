package com.lamkadam.inventoryservice.repository;

import com.lamkadam.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product ,String> {
}

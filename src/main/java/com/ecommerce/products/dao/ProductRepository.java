// Interface for Products
package com.ecommerce.products.dao;

import com.ecommerce.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface extends the JpaRepository, receives a Product and ID (PK)
public interface ProductRepository extends JpaRepository<Product, Long> {

}

// Interface for Products
package com.ecommerce.products.dao;

import com.ecommerce.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

// Interface extends the JpaRepository, receives a Product and ID (PK)
// CrossOrigin annotation allows one to fetch resources from another URL
@CrossOrigin("http://localhost:4200") // frontend
public interface ProductRepository extends JpaRepository<Product, Long> {

}

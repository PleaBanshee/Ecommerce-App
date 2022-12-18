// Interface for Products
package com.ecommerce.products.dao;

import com.ecommerce.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

// Interface extends the JpaRepository, receives a Product and ID (PK)
// CrossOrigin annotation allows one to fetch resources from another URL
@CrossOrigin("http://localhost:4200") // frontend
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Query Method: find a page (category) by ID. Spring Data REST will automatically expose the endpoint
    // Example: http://localhost:8080/api/products/search/findByCategoryId?id=1
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    // Query Method: Search Box for products
    // Example: http://localhost:8080/api/products/search/findByNameContaining?name=python
    Page<Product> findByNameContaining(@Param("name") String name, Pageable page);


}

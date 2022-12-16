package com.ecommerce.products.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "product_category")
// @Data -- known bug: one-to-many and many-to-one relationships getters and setters
// To avoid issue, use @Getter and @Setter annotations
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    // CascadeType.ALL --- perform all DB operations on entities linked to this entity
    // mappedBy ---  Do NOT create another join table as the relationship is already being mapped by the opposite entity of this relationship.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @Column(name = "products")
    private Set<Product> products;
}

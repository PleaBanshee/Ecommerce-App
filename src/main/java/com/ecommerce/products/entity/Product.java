package com.ecommerce.products.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity // specifies that this is an entity class
@Table(name="product") // table name
@Data // automatically creates getters and setters
public class Product {

    @Id // PK field
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indicates that the persistence provider must assign primary keys for the entity using a database identity column.
    @Column(name = "id") // maps the field to database column
    private Long id;

    // One category can have many products, and many products can belong to a single category
    // FK field to ProductCategory
    // Links to category_id and cannot be null
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private ProductCategory category;
    @Column(name = "sku")
    private String sku;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "active")
    private boolean active;
    @Column(name = "units_in_stock")
    private int unitsInStock;
    @Column(name = "date_created")
    @CreationTimestamp // Hibernate automatically manages the timestamps
    private Date dateCreated;
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

}

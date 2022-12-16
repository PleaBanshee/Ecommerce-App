package com.ecommerce.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Entity // specifies that this is an entity class
@Table(name="product") // table name
@Data // automatically creates getters and setters
public class Product {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private String unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
    private Date dateCreated;
    private Date lastUpdated;

}

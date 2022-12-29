package com.ecommerce.products.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="state")
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne // many states can belong to one country
    @JoinColumn(name = "country_id") //  marks a column as a join column for an entity association or an element collection.
    private Country country;
}

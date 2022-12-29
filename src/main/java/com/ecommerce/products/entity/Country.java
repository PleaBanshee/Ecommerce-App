package com.ecommerce.products.entity;

// @JsonIgnore is used at field level to mark a property or list of properties to be ignored.
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="country") // table name must match DB table name
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    // One country can have many states
    @OneToMany(mappedBy = "country")
    @JsonIgnore // will ignore the states
    private List<State> states;

}

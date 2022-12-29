// Interface (Data Repository) for Countries
package com.ecommerce.products.dao;

import com.ecommerce.products.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// JpaRepository<Entity Class,Primary Key>
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "countries",path = "countries") // expose /countries endpoint
public interface CountryRepository extends JpaRepository<Country, Integer> {
    // http://localhost:8080/api/countries
}

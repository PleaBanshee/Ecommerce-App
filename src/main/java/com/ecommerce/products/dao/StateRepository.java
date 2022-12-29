// Interface for States
package com.ecommerce.products.dao;

import com.ecommerce.products.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

// Repository that receives a State and PK
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {
    // Query Method
    // http://localhost:8080/api/states/search/findByCountryCode?code=US
    List<State> findByCountryCode(@Param("code") String code);
}

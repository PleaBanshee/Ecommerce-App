// REST APIs are read-only in this class
package com.ecommerce.products.config;

import com.ecommerce.products.entity.Product;
import com.ecommerce.products.entity.ProductCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// RepositoryRestConfigurer: Component to configure and customize the setup of Spring Data REST.
@Configuration // allows the use of annotations for dependency injection (one can use Beans).
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    // Autowire JPA Entity Manager for dependency injections
    @Autowired
    public DataRestConfig(EntityManager configEntityManager) {
        entityManager = configEntityManager;
    }

    // method for REST configs and Cross-Origin Resource Sharing
    // Java Lambda: -> --- code which receives parameters and returns a value
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        // disable HTTP methods for Product: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class) // apply to Product class
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) // for a single product
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions)); // for multiple products
        // disable HTTP methods for Product Categories: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        // call an internal helper method to expose IDs
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity IDs
        // ====================
        // get a list of entity classes from Entity Manager
        // Test link: http://localhost:8080/api/product-category
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<Class> entityClasses = new ArrayList<>();
        for (EntityType entityType: entities) {
            entityClasses.add(entityType.getJavaType());
        }
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes); // expose all entity IDs
    }
}

// Will return error 405 when using REST methods that are not allowed
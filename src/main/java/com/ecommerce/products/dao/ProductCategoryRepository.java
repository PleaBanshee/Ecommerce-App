// Interface for Product Categories
package com.ecommerce.products.dao;

import com.ecommerce.products.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// customize export mapping and rels.
// collectionResourceRel: rel value to use when generating links to the collection resource (name of JSON entry)
// path: path segment under which this resource is to be exported (endpoint)
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}

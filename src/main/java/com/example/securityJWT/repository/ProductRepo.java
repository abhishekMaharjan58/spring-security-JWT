package com.example.securityJWT.repository;

import com.example.securityJWT.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepo extends CrudRepository<Product, Integer> {

    @Query(value = "select * from product a where a.status=true", nativeQuery = true)
    List<Map<String, Object>> getAll();

    @Query(value = "select * from product a where a.id = ?1", nativeQuery = true)
    Optional<Product> findByProductId(Integer id);

    @Query(value = "Select * from product a where a.id = ?1 ", nativeQuery = true)
    Product selectProduct(Integer id);

}

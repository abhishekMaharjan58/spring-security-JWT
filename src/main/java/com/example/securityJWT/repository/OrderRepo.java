package com.example.securityJWT.repository;

import com.example.securityJWT.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderRepo extends CrudRepository<Order, Integer> {
    @Query(value = "select * from orders a where a.status=true", nativeQuery = true)
    List<Map<String, Object>> getAll();

    @Query(value = "select * from order a where a.id = ?1", nativeQuery = true)
    Optional<Order> findByOrderId(Integer id);
}

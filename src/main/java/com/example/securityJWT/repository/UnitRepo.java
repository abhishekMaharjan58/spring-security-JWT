package com.example.securityJWT.repository;

import com.example.securityJWT.model.Unit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitRepo extends CrudRepository<Unit, Integer> {
    @Query(value = "select * from unit a where a.id = ?1", nativeQuery = true)
    Optional<Unit> findByUnitId(Integer id);
}

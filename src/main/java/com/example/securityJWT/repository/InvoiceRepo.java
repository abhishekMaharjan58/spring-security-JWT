package com.example.securityJWT.repository;

import com.example.securityJWT.model.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InvoiceRepo extends CrudRepository<Invoice, Integer> {
    @Query(value = "select * from invoice a where a.status=true", nativeQuery = true)
    List<Map<String, Object>> getAll();

    @Query(value = "select * from invoice a where a.id = ?1", nativeQuery = true)
    Optional<Invoice> findByInvoiceId(Integer id);
}

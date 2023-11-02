package com.example.securityJWT.controller;

import com.example.securityJWT.pojo.ProductPojo;
import com.example.securityJWT.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping(value = "/")
    public List<Map<String, Object>> getAllProducts() {
        try {
            return productService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return (List<Map<String, Object>>) ResponseEntity.status(500).body(ex.getLocalizedMessage());
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> addProduct(@RequestBody ProductPojo productPojo) {
        try {
            return ResponseEntity.ok(productService.addProduct(productPojo));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body(ex.getLocalizedMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductPojo productPojo, @PathVariable Integer id) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, productPojo));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body(ex.getLocalizedMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable Integer id) {
        try {
            productService.removeProduct(id);
            return ResponseEntity.ok("Success");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body("Error");
        }
    }
}
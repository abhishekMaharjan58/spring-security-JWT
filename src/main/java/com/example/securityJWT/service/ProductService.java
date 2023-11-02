package com.example.securityJWT.service;

import com.example.securityJWT.model.Product;
import com.example.securityJWT.pojo.ProductPojo;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Map<String, Object>> getAll();

    ProductPojo addProduct(ProductPojo productPojo) throws Exception;

    ProductPojo updateProduct(Integer id, ProductPojo productPojo);

    void removeProduct(Integer id) throws Exception;

    Product checkIt(Integer id) throws Exception;

}

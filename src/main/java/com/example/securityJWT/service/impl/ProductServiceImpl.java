package com.example.securityJWT.service.impl;

import com.example.securityJWT.model.Product;
import com.example.securityJWT.model.Unit;
import com.example.securityJWT.pojo.ProductPojo;
import com.example.securityJWT.repository.ProductRepo;
import com.example.securityJWT.service.ProductService;
import com.example.securityJWT.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final UnitService unitService;

    @Override
    public Product checkIt(Integer id) throws Exception {
        Optional<Product> optionalProduct = productRepo.findByProductId(id);
        if (optionalProduct.isPresent()) return optionalProduct.get();
        throw new Exception("Id Not Found");
    }

    @Override
    public List<Map<String, Object>> getAll() {
        return productRepo.getAll();
    }

    @Override
    public ProductPojo addProduct(ProductPojo productPojo) throws Exception {
        Product product;
        if (productPojo.getId() != null)   //update Instance Creation
            product = checkIt(productPojo.getId());
        else  // create new Instance
            product = new Product();
        product.setDescription(productPojo.getDescription());
        product.setName(productPojo.getName());
        product.setPrice(productPojo.getPrice());
        Unit unit = unitService.saveUnit(productPojo.getUnitPojo());
        productPojo.getUnitPojo().setId(unit.getId());
        product.setUnit(unit);
        Product result = productRepo.save(product);
        productPojo.setId(result.getId());
        return productPojo;
    }

    @Override
    public ProductPojo updateProduct(Integer id, ProductPojo productPojo) {
        Product product = productRepo.selectProduct(id);
        product.setDescription(productPojo.getDescription());
        product.setName(productPojo.getName());
        product.setPrice(productPojo.getPrice());
        Product result = productRepo.save(product);
        return productPojo;
    }

    @Override
    public void removeProduct(Integer id) throws Exception {
        Product product;
        product = checkIt(id);
        Boolean status = product.getStatus();
        product.setStatus(!status);
        productRepo.save(product);
    }
}
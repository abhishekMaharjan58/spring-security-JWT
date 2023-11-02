package com.example.securityJWT.pojo;

import lombok.Data;

@Data
public class ProductPojo {
    private Integer id;

    private String name;

    private Integer price;

    private String description;

    private Boolean status = true;

    private UnitPojo unitPojo;
}

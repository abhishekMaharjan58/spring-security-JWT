package com.example.securityJWT.pojo;

import lombok.Data;

@Data
public class OrderPojo {
    private Integer id;
    private Integer userId;
    private Integer quantity;
    private Integer productId;
    private Integer price;
}

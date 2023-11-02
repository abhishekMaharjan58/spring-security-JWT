package com.example.securityJWT.service;

import com.example.securityJWT.model.Invoice;
import com.example.securityJWT.model.Order;
import com.example.securityJWT.pojo.OrderPojo;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Map<String, Object>> getAll();

    Order checkIt(Integer id) throws Exception;

    List<OrderPojo> addOrder(List<OrderPojo> orderPojo, Invoice invoice) throws Exception;
}

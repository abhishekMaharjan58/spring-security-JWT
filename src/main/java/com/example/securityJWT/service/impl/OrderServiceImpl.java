package com.example.securityJWT.service.impl;

import com.example.securityJWT.model.Invoice;
import com.example.securityJWT.model.Order;
import com.example.securityJWT.model.Product;
import com.example.securityJWT.model.User;
import com.example.securityJWT.pojo.OrderPojo;
import com.example.securityJWT.repository.OrderRepo;
import com.example.securityJWT.service.OrderService;
import com.example.securityJWT.service.ProductService;
import com.example.securityJWT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    private final ProductService productService;

    private final UserService userService;

    @Override
    public Order checkIt(Integer id) throws Exception {
        Optional<Order> optionalOrder = orderRepo.findByOrderId(id);
        if (optionalOrder.isPresent())
            return optionalOrder.get();
        throw new Exception("Id Not Found");
    }


    @Override
    public List<OrderPojo> addOrder(List<OrderPojo> orderPojoList, Invoice invoice) throws Exception {
        Order order;
        for (OrderPojo orderPojo : orderPojoList) {
            if (orderPojo.getId() != null)
                order = checkIt(orderPojo.getId());
            else
                order = new Order();
            Product product = productService.checkIt(orderPojo.getProductId());
            order.setProduct(product);
            User user = userService.checkIt(orderPojo.getUserId());
            order.setUser(user);
            order.setInvoice(invoice);
            order.setQuantity(orderPojo.getQuantity());
            Order result = orderRepo.save(order);
            orderPojo.setId(result.getId());
            orderPojo.setPrice(product.getPrice() * order.getQuantity());
        }
        return orderPojoList;
    }

    @Override
    public List<Map<String, Object>> getAll() {
        return orderRepo.getAll();

    }
}

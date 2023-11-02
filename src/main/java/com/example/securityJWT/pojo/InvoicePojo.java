package com.example.securityJWT.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InvoicePojo {
    Integer id;
    Integer total;
    Date date;
    Boolean status;
    List<OrderPojo> orderPojoList;
}

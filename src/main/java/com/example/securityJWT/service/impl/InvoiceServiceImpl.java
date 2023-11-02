package com.example.securityJWT.service.impl;

import com.example.securityJWT.model.Invoice;
import com.example.securityJWT.pojo.InvoicePojo;
import com.example.securityJWT.pojo.OrderPojo;
import com.example.securityJWT.repository.InvoiceRepo;
import com.example.securityJWT.service.InvoiceService;
import com.example.securityJWT.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepo invoiceRepo;

    private final OrderService orderService;

    public Invoice checkIt(Integer invoiceId) throws Exception {
        Optional<Invoice> optionalInvoice = invoiceRepo.findByInvoiceId(invoiceId);
        if (optionalInvoice.isPresent())
            return optionalInvoice.get();
        throw new Exception("Id Not Found");
    }

    public InvoicePojo addInvoice(InvoicePojo invoicePojo) throws Exception {
        Invoice invoice;
        if (invoicePojo.getId() != null)
            invoice = checkIt(invoicePojo.getId());
        else
            invoice = new Invoice();
        invoice.setDate(invoicePojo.getDate());
        invoice.setTotal(0);
        Invoice result = invoiceRepo.save(invoice);
        invoicePojo.setId(result.getId());
        invoicePojo.setOrderPojoList(orderService.addOrder(invoicePojo.getOrderPojoList(), invoice));
        Integer total = 0;
        for (OrderPojo orderPojo : invoicePojo.getOrderPojoList())
            total += orderPojo.getPrice();
        result.setTotal(total);
        invoiceRepo.save(result);
        invoicePojo.setTotal(total);
        return invoicePojo;
    }
}

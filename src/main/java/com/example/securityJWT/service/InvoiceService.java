package com.example.securityJWT.service;

import com.example.securityJWT.model.Invoice;
import com.example.securityJWT.pojo.InvoicePojo;

public interface InvoiceService {
    InvoicePojo addInvoice(InvoicePojo invoicePojo) throws Exception;

    Invoice checkIt(Integer id) throws Exception;
}

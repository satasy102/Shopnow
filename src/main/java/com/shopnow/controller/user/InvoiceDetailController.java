package com.shopnow.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/invoiceDetails")
public class InvoiceDetailController {
    @GetMapping
    public String index(){
        return "admin/invoiceDetail";
    }
}

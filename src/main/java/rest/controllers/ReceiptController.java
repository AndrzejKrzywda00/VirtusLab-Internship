package rest.controllers;

import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptGenerator service;

    @GetMapping("")
    public Receipt get() {
        return service.generateFromBasketDatabase();
    }

}

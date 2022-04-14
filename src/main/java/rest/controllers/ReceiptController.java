package rest.controllers;

import com.virtuslab.internship.receipt.Receipt;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.services.ReceiptService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptService service;

    @GetMapping("")
    public Receipt get() {
        return service.get();
    }

}

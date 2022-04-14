package rest.services;

import com.virtuslab.internship.receipt.Receipt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReceiptService {

    // GET
    public Receipt get() {
        // TODO -- implement this
        return new Receipt(new ArrayList<>());
    }

}

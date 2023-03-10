package com.maicon.hrpayroll.services;

import com.maicon.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days) {
        return new Payment("Maicon", 200.0, days);
    }
}

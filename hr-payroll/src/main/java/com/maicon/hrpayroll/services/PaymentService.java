package com.maicon.hrpayroll.services;

import com.maicon.hrpayroll.entities.Payment;
import com.maicon.hrpayroll.entities.Worker;
import com.maicon.hrpayroll.feignclients.WorkerFeignClient;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

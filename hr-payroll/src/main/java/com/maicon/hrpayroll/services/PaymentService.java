package com.maicon.hrpayroll.services;

import com.maicon.hrpayroll.entities.Payment;
import com.maicon.hrpayroll.entities.Worker;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    //Recupera o valor do application.properties
    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();

        //""+workerId - convert long para string
        uriVariables.put("id", ""+workerId);

        //getForObject(uri, tipo que será buscado, uriVariables)
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

package com.maicon.hrpayroll.feignclients;

import com.maicon.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
//o name tem que ter o mesmo nome que está
//no application.properties que será
//localhost:8001/workers
@FeignClient(name = "hr-worker", path = "workers")
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}

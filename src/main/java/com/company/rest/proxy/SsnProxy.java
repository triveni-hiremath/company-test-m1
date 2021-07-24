package com.company.rest.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* To communicate between the Services  use the FeignClient*/
@FeignClient(value = "ssn-service", url = "http://localhost:8081")
public interface SsnProxy {

    @GetMapping(value = "/ssn/{number}")
    String validate(@PathVariable("number") String number);
}

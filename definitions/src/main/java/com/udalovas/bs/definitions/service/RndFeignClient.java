package com.udalovas.bs.definitions.service;

import com.udalovas.bs.definitions.model.RndValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("rnd-service")
public interface RndFeignClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/bs/rnd/char",
            consumes = "application/json"
    )
    RndValue getRndChar();
}

package com.udalovas.bs.rnd.controller;

import com.udalovas.bs.rnd.model.RndValue;
import com.udalovas.bs.rnd.service.RndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/bs/rnd")
public class RndController {

    private RndService rndService;

    @Autowired
    public RndController(RndService rndService) {
        this.rndService = rndService;
    }

    @RequestMapping(value = "/char", method = RequestMethod.GET)
    public RndValue getChar() {
        return new RndValue(String.valueOf(rndService.getRndChar()));
    }
}

package com.udalovas.bs.definitions.controller;

import com.udalovas.bs.definitions.model.Definition;
import com.udalovas.bs.definitions.service.DefinitionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/bs/definitions")
public class DefinitionsController {

    private DefinitionsService definitionsService;

    @Autowired
    public DefinitionsController(DefinitionsService definitionsService) {
        this.definitionsService = definitionsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Definition> getDefinitions(@RequestParam(defaultValue = "0") int offset,
                                           @RequestParam(defaultValue = "20") int limit,
                                           @RequestParam(defaultValue = "true") boolean shuffle) {
        return definitionsService.getDefinitions();
    }

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public Definition getSampleDefinition() {
        return definitionsService.getSample();
    }

    @RequestMapping(value = "/weird", method = RequestMethod.GET)
    public Definition getWeirdDefinition() {
        return definitionsService.getWeirdDefinition();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Definition addDefinition(@RequestBody Definition definition) {
        return definitionsService.addDefinition(definition);
    }
}

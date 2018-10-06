package com.udalovas.bs.definitions.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.udalovas.bs.definitions.model.Definition;
import com.udalovas.bs.definitions.repository.DefinitionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefinitionsService {

    @Autowired
    private RndFeignClient rndFeignClient;

    @Autowired
    private DefinitionsRepository definitionsRepository;

    @Autowired
    private ServiceConfig serviceConfig;

    @HystrixCommand
    public List<Definition> getDefinitions() {
        List<Definition> definitions = new ArrayList<>();
        definitionsRepository.findAll().forEach(definitions::add);
        return definitions;
    }

    public Definition getSample() {
        return new Definition().withText(serviceConfig.getDefinitionsSampleText());
    }

    @HystrixCommand(fallbackMethod = "fallbackWeirdDefinition")
    public Definition getWeirdDefinition() {
        return new Definition().withText(rndFeignClient.getRndChar().getValue());
    }

    private Definition fallbackWeirdDefinition() {
        return new Definition()
                .withText("fallback for weird definition, please use it while true service is getting up back");
    }

    @HystrixCommand
    public Definition addDefinition(Definition definition) {
        return definitionsRepository.save(definition);
    }
}

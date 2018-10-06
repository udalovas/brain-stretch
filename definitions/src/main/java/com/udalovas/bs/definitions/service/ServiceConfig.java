package com.udalovas.bs.definitions.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {

    // TODO ${definitions.sample.text} doesn't work for some reason
    // ... , so program can't inject property from the Spring Cloud Config
    // TODO use encrypted properties for sensitive data
    // TODO take properties from Git
    @Value("definitions.sample.text")
    private String definitionsSampleText;

    public String getDefinitionsSampleText() {
        return definitionsSampleText;
    }
}

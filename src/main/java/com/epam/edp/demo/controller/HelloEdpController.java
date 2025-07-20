package com.epam.edp.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo_Yemelianov
 */
@RestController
public class HelloEdpController {

    @GetMapping(value = "/api/hello")
    public String hello() {
        return "Hello, EDP!";
    }

    @GetMapping(value = "/env")
    public Map<String, Object> getEnv() {
        Map<String, Object> result = new HashMap<>();
        result.put("environmentVariables", System.getenv());
        return result;
    }

    @GetMapping(value = "/config")
    public Map<String, Object> getConfigFiles() {
        Map<String, Object> result = new HashMap<>();
        String configFilePath = "/config/application.properties";
        try {
            String configContent = Files.readString(Paths.get(configFilePath));
            result.put("application.properties.from.configmap", configContent);
        } catch (IOException e) {
            result.put("application.properties.from.configmap", "Failed to read file: " + e.getMessage());
        }

        String secretFilePath = "/secret-config/application.secret.properties";
        try {
            String secretContent = Files.readString(Paths.get(secretFilePath));
            result.put("application.secret.properties.from.secret", secretContent);
        } catch (IOException e) {
            result.put("application.secret.properties.from.secret", "Failed to read file: " + e.getMessage());
        }
        return result;
    }
}

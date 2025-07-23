package com.epam.edp.demo.controller;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${application.properties.from.configmap:}")
    private String configMapProperties;

    @Value("${application.secret.properties.from.secret:}")
    private String secretProperties;

    @GetMapping(value = "/api/hello")
    public String hello() {
        return "Hello, EDP!";
    }

    @GetMapping(value = "/env")
    public Map<String, Object> getEnv() {
        Map<String, Object> result = new HashMap<>();
        result.put("environmentVariables", System.getenv());

        String configMapContent = null;
        String secretContent = null;
        try {
            configMapContent = new String(Files.readAllBytes(Paths.get("/config/application.properties")));
            secretContent = new String(Files.readAllBytes(Paths.get("/secret-config/application.secret.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        result.put("application.properties.from.configmap", configMapContent);
        result.put("application.secret.properties.from.secret", secretContent);

        return result;
    }

}

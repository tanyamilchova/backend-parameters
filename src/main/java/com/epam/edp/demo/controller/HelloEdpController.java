package com.epam.edp.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Pavlo_Yemelianov
 */
@RestController
public class HelloEdpController {

    @Value("${application.properties.path:/config/application.properties}")
    private String configMapConfigPath;

    @Value("${application.secret.properties.path:/secret-config/application.secret.properties}")
    private String secretConfigPath;

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        // TreeMap for sorted and readable output
        Map<String, String> env = new TreeMap<>(System.getenv());

        // Add contents of mounted property files
        env.put("application.properties.from.configmap", readFileContent(configMapConfigPath));
        env.put("application.secret.properties.from.secret", readFileContent(secretConfigPath));

        return env;
    }

    private String readFileContent(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            return "File not found or unreadable: " + e.getMessage();
        }
    }

}

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

    // Allowed keys - those present in the second set you provided
    private static final Set<String> ALLOWED_KEYS = Set.of(
            "BACKEND_PARAMETERS_PORT",
            "BACKEND_PARAMETERS_PORT_8080_TCP",
            "BACKEND_PARAMETERS_PORT_8080_TCP_ADDR",
            "BACKEND_PARAMETERS_PORT_8080_TCP_PORT",
            "BACKEND_PARAMETERS_PORT_8080_TCP_PROTO",
            "BACKEND_PARAMETERS_SERVICE_HOST",
            "BACKEND_PARAMETERS_SERVICE_PORT",
            "BACKEND_PARAMETERS_SERVICE_PORT_HTTP",
            "FLASK_RUN_FROM_CLI",
            "GPG_KEY",
            "HOME",
            "HOSTNAME",
            "KUBERNETES_PORT",
            "KUBERNETES_PORT_443_TCP",
            "KUBERNETES_PORT_443_TCP_ADDR",
            "KUBERNETES_PORT_443_TCP_PORT",
            "KUBERNETES_PORT_443_TCP_PROTO",
            "KUBERNETES_SERVICE_HOST",
            "KUBERNETES_SERVICE_PORT",
            "KUBERNETES_SERVICE_PORT_HTTPS",
            "LANG",
            "PATH",
            "PYTHON_VERSION",
            "WERKZEUG_SERVER_FD"
    );

    @GetMapping("/")
    public Map<String, String> getEnv() {
        Map<String, String> systemEnv = System.getenv();
        Map<String, String> filteredEnv = new TreeMap<>();

        // Filter environment variables to only those allowed
        for (String key : systemEnv.keySet()) {
            if (ALLOWED_KEYS.contains(key)) {
                filteredEnv.put(key, systemEnv.get(key));
                System.out.println("Key: " + key + ", Value: " + systemEnv.get(key));
            }
        }

        // Add contents of mounted property files


        filteredEnv.put("application.properties.from.configmap", readFileContent(configMapConfigPath));
        filteredEnv.put("application.secret.properties.from.secret", readFileContent(secretConfigPath));

        return filteredEnv;
    }

    private String readFileContent(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            return "File not found or unreadable: " + e.getMessage();
        }
    }

}

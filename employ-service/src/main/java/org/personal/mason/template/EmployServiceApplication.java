package org.personal.mason.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployServiceApplication.class, args);
    }
}

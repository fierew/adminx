package com.fierew.adminxcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuyang
 */
@SpringBootApplication(scanBasePackages = {"com.fierew.*"})
public class AdminxControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminxControllerApplication.class, args);
    }

}

package com.fierew.adminxcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * @author xuyang
 */
@SpringBootApplication(scanBasePackages = {"com.fierew.*"})
public class AdminxControllerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AdminxControllerApplication.class);
        // System.out.println(System.getProperty("user.dir") + "/app.pid");
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
        // SpringApplication.run(AdminxControllerApplication.class, args);
    }

}

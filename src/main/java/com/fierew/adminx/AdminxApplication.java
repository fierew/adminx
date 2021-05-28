package com.fierew.adminx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * @author xuyang
 */
@SpringBootApplication
public class AdminxApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AdminxApplication.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);
	}

}

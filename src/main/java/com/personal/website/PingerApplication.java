package com.personal.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackageClasses = AppConfig.class)
@ComponentScan(basePackageClasses = Pinger.class)
@ComponentScan(basePackageClasses = MyRestController.class)
@SpringBootApplication
@EnableAutoConfiguration
public class PingerApplication {

	// web: java -jar target/pinger-0.0.1-SNAPSHOT.jar & python pinger.py
	public static void main(String[] args) {
		SpringApplication.run(PingerApplication.class, args);
	}
}
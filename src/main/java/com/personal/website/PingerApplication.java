package com.personal.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ComponentScan(basePackageClasses = AppConfig.class)
@ComponentScan(basePackageClasses = Pinger.class)
@SpringBootApplication
public class PingerApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	// web: java -jar target/pinger-0.0.1-SNAPSHOT.jar & python pinger.py
	public static void main(String[] args) {
		SpringApplication.run(PingerApplication.class, args);
	}
}
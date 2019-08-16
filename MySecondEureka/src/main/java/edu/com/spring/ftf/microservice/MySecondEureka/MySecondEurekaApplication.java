package edu.com.spring.ftf.microservice.MySecondEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MySecondEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySecondEurekaApplication.class, args);
	}

}

package edu.com.spring.ftf.ms2.MySecondSpringApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class MySecondSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySecondSpringApiApplication.class, args);
    }

}

@RestController
class ServiceInstanceRestController {
    @GetMapping({"/", "/status"})
	public String status() {
        return "ok";
    }
}
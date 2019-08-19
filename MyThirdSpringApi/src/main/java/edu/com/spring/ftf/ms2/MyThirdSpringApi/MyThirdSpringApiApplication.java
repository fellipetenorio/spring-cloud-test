package edu.com.spring.ftf.ms2.MyThirdSpringApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class MyThirdSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyThirdSpringApiApplication.class, args);
    }

}

@RestController
class MyRestController {
    @RequestMapping({"/status", "/"})
    public String status() {
        return "ThirdService: ok";
    }
}
package edu.com.spring.ftf.ms2.MySecondSpringApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
@RibbonClient(
        name = "ping-server",
        configuration = RibbonConfiguration.class
)
public class MySecondSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySecondSpringApiApplication.class, args);
    }

    @GetMapping({"/", "/status"})
    public String status(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }
}


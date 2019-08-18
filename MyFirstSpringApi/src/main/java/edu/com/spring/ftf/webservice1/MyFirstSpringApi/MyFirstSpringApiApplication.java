package edu.com.spring.ftf.webservice1.MyFirstSpringApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class MyFirstSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringApiApplication.class, args);
    }

}

@RestController
class ServiceInstanceRestController {
    private final DiscoveryClient discoveryClient;


    public ServiceInstanceRestController(@Autowired DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping("/service-instances")
    public List<ServiceInstance> serviceInstancesByApplicationName() {
        List<ServiceInstance> serviceInstances = new ArrayList<>();
        this.discoveryClient.getServices().forEach(s -> {
            serviceInstances.addAll(this.discoveryClient.getInstances(s));
        });
        return serviceInstances;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "index " + request.getRequestURI();
    }

    @GetMapping("/temp")
    public String status(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @GetMapping("/asdfasdf")
    public String t2(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @GetMapping("/?<segment>.*")
    public String handle(HttpServletRequest request) {
        return request.getRequestURI();
    }
}
package org.rudra.eureka.customer.shared.client;

import org.rudra.eureka.customer.shared.CustomerServiceFeignClient;
import org.rudra.eureka.event.EventServiceFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses ={ CustomerServiceFeignClient.class, EventServiceFeignClient.class})
@ComponentScan(basePackageClasses = CustomerServiceFeignClient.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}



package it.discovery.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
@RibbonClient("statistics")
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate statisticsRestTemplate() {
        return new RestTemplate();
    }
}

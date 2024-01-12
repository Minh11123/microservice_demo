package com.example.microservice_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroserviceDemoApplication.class, args);
    }

}

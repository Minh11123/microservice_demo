package com.example.microservice_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication

public class MicroserviceDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroserviceDemoApplication.class, args);
    }

}

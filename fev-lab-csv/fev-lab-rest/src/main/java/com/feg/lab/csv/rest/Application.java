package com.feg.lab.csv.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.feg.lab.csv.rest"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

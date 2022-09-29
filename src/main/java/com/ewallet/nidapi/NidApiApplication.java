package com.ewallet.nidapi;


import com.ewallet.nidapi.initialize.InitializeData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NidApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NidApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(InitializeData initializeData) {
        return args -> initializeData.initialize();
    }
}

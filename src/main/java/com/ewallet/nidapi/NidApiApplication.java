package com.ewallet.nidapi;

import com.ewallet.nidapi.initialize.InitializeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NidApiApplication implements CommandLineRunner {

    @Autowired
    private InitializeData initializeData;

    public static void main(String[] args) {
        SpringApplication.run(NidApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        initializeData.initialize();
    }
}

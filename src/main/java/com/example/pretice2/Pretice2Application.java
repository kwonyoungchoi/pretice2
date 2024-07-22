package com.example.pretice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Pretice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Pretice2Application.class, args);
    }

}

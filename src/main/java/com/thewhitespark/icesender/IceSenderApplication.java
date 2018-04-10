package com.thewhitespark.icesender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IceSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(IceSenderApplication.class, args);
    }
}

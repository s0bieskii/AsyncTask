package com.task.CDQTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CdqTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdqTaskApplication.class, args);
    }
}

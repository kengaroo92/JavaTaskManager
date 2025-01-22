package com.example.javataskmanager;

import org.springframework.boot.SpringApplication; //Bootstrap to launch the app from a main method.
import org.springframework.boot.autoconfigure.SpringBootApplication; //Annotations

@SpringBootApplication //Component Scanning and auto configurations.
public class JavaTaskManagerApplication { //Entry point.

    public static void main(String[] args) {
        SpringApplication.run(JavaTaskManagerApplication.class, args);
    }

}
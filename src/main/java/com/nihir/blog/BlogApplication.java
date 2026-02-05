package com.nihir.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone; // Don't forget this import!

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        // 1. FORCE TIMEZONE FIX FIRST
        // We use "UTC" because it is universally accepted by all databases.
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("Timezone explicitly set to UTC to avoid PSQLException");

        // 2. Start the application
        SpringApplication.run(BlogApplication.class, args);
    }
}
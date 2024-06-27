package com.crud.producto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProductosApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringProductosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Código que se ejecutará al iniciar la aplicación
    }
}

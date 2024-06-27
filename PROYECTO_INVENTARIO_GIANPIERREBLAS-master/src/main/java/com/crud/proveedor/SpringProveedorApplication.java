package com.crud.proveedor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProveedorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringProveedorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Código que se ejecutará al iniciar la aplicación
    }
}

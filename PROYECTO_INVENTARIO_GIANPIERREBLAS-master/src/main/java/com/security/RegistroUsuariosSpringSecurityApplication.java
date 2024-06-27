package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.crud.proveedor", "com.crud.producto", "com.crud.categoria", "com.security"})
public class RegistroUsuariosSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
        System.out.println("Hola Mundo");
    }
}

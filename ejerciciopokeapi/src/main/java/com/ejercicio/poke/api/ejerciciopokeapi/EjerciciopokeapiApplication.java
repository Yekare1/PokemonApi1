package com.ejercicio.poke.api.ejerciciopokeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.ejercicio.poke.api.ejerciciopokeapi",
    "com.ejercicio.poke.api.ejerciciopokeapi.controllers",
    "com.ejercicio.poke.api.ejerciciopokeapi.services",
    "com.ejercicio.poke.api.ejerciciopokeapi.configuration"
})
public class EjerciciopokeapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EjerciciopokeapiApplication.class, args);
    }
}
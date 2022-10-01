package com.nttdata.cursofullstack.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Esto es para declarar un RestController (poder ocupar get, post, put, delete)
@RestController
//nos permite darle la url de nuestro servicio
@RequestMapping("/hola-mundo-controller")
//Nos permite aceptar Request de cualquier App
@CrossOrigin("*")
//nos permite logear por consola
@Log4j2
public class HolaMundoController {

    @GetMapping
    public ResponseEntity<?> saludar(){
        log.info("Ejecutando Controllador HolaMundo Funcion Saludar");
        return ResponseEntity.status(HttpStatus.OK).body("Hola Desde HolaMundoController");
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> suladarPorNombre(@PathVariable String name){
        log.info("Necesito Saludar a "+name);
        return ResponseEntity.status(HttpStatus.OK).body("Hola "+name);
    }

    @GetMapping("/alternativo/{name}")
    public ResponseEntity<?> suladarPorNombreAlternativo(@PathVariable String name){
        log.info("Necesito Saludar a "+name+" de Forma Alternativa");
        return ResponseEntity.status(HttpStatus.OK).body("Hola "+name+" De forma Alternativa");
    }


}

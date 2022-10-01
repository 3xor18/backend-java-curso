package com.nttdata.cursofullstack.controller;

import com.nttdata.cursofullstack.dtos.UsuarioDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/segundocontroller")
@CrossOrigin("*")
@Log4j2
public class SegundoController {

    @GetMapping
    public ResponseEntity<?> funcionUno(){
       log.info("Ejecutando en SegundoController la FuncionUno");
       return ResponseEntity.status(HttpStatus.OK).body("Hola desde SegundoController Ejecute la FuncionUno GIT");
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> funcionDos(@PathVariable String nombre){
        log.info("Ejecutando en SegundoController la funcionDos");
        return ResponseEntity.status(HttpStatus.OK).body("Hola desde SegundoController Ejecute la funcionDos y tu nombre es "+nombre);
    }

    @GetMapping("/{nombre}/{nombre2}")
    public ResponseEntity<?> funcionDosConDosVariables(@PathVariable String nombre,@PathVariable String nombre2){
        log.info("Ejecutando en SegundoController la funcionDosConDosVariables");
        return ResponseEntity.status(HttpStatus.OK).body("Hola desde SegundoController Ejecute la funcionDosConDosVariables y tu nombre es "+nombre+" y el segundo es:"+nombre2);
    }

    @PostMapping
    public ResponseEntity<?> funcionTres(@RequestBody UsuarioDto dataEntrante){
        log.info("Ejecutando en SegundoController la funcionTres");
        return ResponseEntity.status(HttpStatus.OK).body("Hola desde SegundoController Ejecute la funcionTres con Nombre:"+
                dataEntrante.getName()+" y el password:"+dataEntrante.getClave()
        );
    }

    @PostMapping("/ycrearcuenta")
    public ResponseEntity<?> funcionTresAlgo(){
        log.info("Ejecutando en SegundoController la funcionTresAlgo");
        return ResponseEntity.status(HttpStatus.OK).body("Hola desde SegundoController Ejecute la funcionTresAlgo");
    }

    @PutMapping("/{idAlgo}")
    public ResponseEntity<?> funcionCuatro(@PathVariable String idAlgo){
        log.info("Ejecutando en SegundoController la funcionCuatro");
        return ResponseEntity.status(HttpStatus.OK).body("Hola desde SegundoController Ejecute la funcionCuatro "+idAlgo);
    }

    @DeleteMapping
    public ResponseEntity<?> funcionCinco(@PathVariable String idAlgo){
        log.info("Ejecutando en SegundoController la funcionCinco");
        return ResponseEntity.status(HttpStatus.OK).body("Hola desde SegundoController Ejecute la funcionCinco "+idAlgo);
    }
}

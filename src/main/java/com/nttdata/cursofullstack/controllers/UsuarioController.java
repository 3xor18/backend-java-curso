package com.nttdata.cursofullstack.controllers;

import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import com.nttdata.cursofullstack.services.UsuarioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
@Log4j2
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> crear(@RequestBody UsuarioParaCrear dataEntrante){
        return service.crearDesdeElService(dataEntrante);
    }

    @GetMapping
    public ResponseEntity<?> consultar(){
        return ResponseEntity.status(HttpStatus.OK).body("Hola Desde El usuario Controller metodo consultar");
    }
}

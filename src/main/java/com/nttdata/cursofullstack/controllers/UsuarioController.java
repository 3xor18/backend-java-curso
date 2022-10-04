package com.nttdata.cursofullstack.controllers;

import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import com.nttdata.cursofullstack.services.UsuarioService;
import lombok.extern.log4j.Log4j2;
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
    public ResponseEntity<?> consultarTodos(){
        return service.consultarTodo();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> consultarUno(@PathVariable  Long idUsuario){
        return service.consultarUno(idUsuario);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,@RequestBody UsuarioParaCrear dataEntrante){
        return service.actualizar(id,dataEntrante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        return service.borrar(id);
    }
}

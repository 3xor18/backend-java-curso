package com.nttdata.cursofullstack.controllers;

import com.nttdata.cursofullstack.dtos.AutorParaGuardar;
import com.nttdata.cursofullstack.dtos.CursoParaCrearDto;
import com.nttdata.cursofullstack.services.AutorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
@CrossOrigin("*")
@Log4j2
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> crear(@RequestBody AutorParaGuardar dto){
        return service.crear(dto);
    }


    @GetMapping
    public ResponseEntity<?> consultarTodos(){
        return service.consultarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarUno(@PathVariable Long id){
        return service.consultarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,@RequestBody AutorParaGuardar dataEntrante){
        return service.modificar(id,dataEntrante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        return service.eliminar(id);
    }
}

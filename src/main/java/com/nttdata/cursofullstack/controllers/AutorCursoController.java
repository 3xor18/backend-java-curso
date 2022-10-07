package com.nttdata.cursofullstack.controllers;

import com.nttdata.cursofullstack.dtos.AutorCursoDto;
import com.nttdata.cursofullstack.dtos.AutorParaGuardar;
import com.nttdata.cursofullstack.services.AutorCursoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor-curso")
@CrossOrigin("*")
@Log4j2
public class AutorCursoController {

    private final AutorCursoService service;

    public AutorCursoController(AutorCursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody AutorCursoDto dto){
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
    public ResponseEntity<?> actualizar(@PathVariable Long id,@RequestBody AutorCursoDto dataEntrante){
        return service.modificar(id,dataEntrante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        return service.eliminar(id);
    }
}

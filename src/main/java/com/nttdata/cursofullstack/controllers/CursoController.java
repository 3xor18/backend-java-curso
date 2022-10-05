package com.nttdata.cursofullstack.controllers;

import com.nttdata.cursofullstack.dtos.CursoEditarPorNombre;
import com.nttdata.cursofullstack.dtos.CursoParaCrearDto;
import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import com.nttdata.cursofullstack.services.CursoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
@CrossOrigin("*")
@Log4j2
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CursoParaCrearDto dto){
        return service.crear(dto);
    }


    @GetMapping
    public ResponseEntity<?> consultarTodos(){
        return service.consultarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarUno(@PathVariable  Long id){
        return service.consultarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,@RequestBody CursoParaCrearDto dataEntrante){
        return service.modificar(id,dataEntrante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        return service.eliminar(id);
    }

    @PutMapping("/modificarpornombre")
    public ResponseEntity<?> actualizarPorNombre(@RequestBody CursoEditarPorNombre dataEntrante){
        return service.modificarPorNombre(dataEntrante);
    }
}

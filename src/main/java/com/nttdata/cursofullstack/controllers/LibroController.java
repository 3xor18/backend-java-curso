package com.nttdata.cursofullstack.controllers;

import com.nttdata.cursofullstack.services.LibroService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libro")
@CrossOrigin("*")
@Log4j2
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> crear(){
        return service.guardar();
    }
}

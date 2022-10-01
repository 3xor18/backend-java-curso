package com.nttdata.cursofullstack.controller;

import com.nttdata.cursofullstack.dtos.UsuarioParaGuardarDto;
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
   public ResponseEntity<?> guardar(@RequestBody UsuarioParaGuardarDto dataEntrante){
       return service.save(dataEntrante);
   }


}

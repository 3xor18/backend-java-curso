package com.nttdata.cursofullstack.services.impl;

import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import com.nttdata.cursofullstack.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public class UsuarioServicePostgressImpl implements UsuarioService {
    @Override
    public ResponseEntity<?> crearDesdeElService(UsuarioParaCrear dataEntrante) {
        return ResponseEntity.status(HttpStatus.OK).body("Estoy guardando en Postgress");
    }

    @Override
    public ResponseEntity<?> consultarTodo() {
        return ResponseEntity.status(HttpStatus.OK).body("Estoy guardando en Postgress");
    }

    @Override
    public ResponseEntity<?> consultarUno(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Estoy guardando en Postgress");
    }

    @Override
    public ResponseEntity<?> actualizar(Long idActualizar, UsuarioParaCrear data) {
        return ResponseEntity.status(HttpStatus.OK).body("Estoy guardando en Postgress");
    }

    @Override
    public ResponseEntity<?> borrar(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Estoy guardando en Postgress");
    }
}

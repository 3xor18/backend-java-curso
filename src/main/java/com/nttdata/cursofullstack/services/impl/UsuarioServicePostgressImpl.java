package com.nttdata.cursofullstack.services.impl;

import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import com.nttdata.cursofullstack.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicePostgressImpl implements UsuarioService {
    @Override
    public ResponseEntity<?> crearDesdeElService(UsuarioParaCrear dataEntrante) {
        return ResponseEntity.status(HttpStatus.OK).body("Estoy guardando en Postgress");
    }
}

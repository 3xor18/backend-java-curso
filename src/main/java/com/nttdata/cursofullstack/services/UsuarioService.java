package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    public ResponseEntity<?> crearDesdeElService(UsuarioParaCrear dataEntrante);
}

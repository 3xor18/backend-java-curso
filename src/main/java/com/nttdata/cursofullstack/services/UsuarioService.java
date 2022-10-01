package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.UsuarioParaGuardarDto;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    public ResponseEntity<?> save(UsuarioParaGuardarDto dataEntrante);
}

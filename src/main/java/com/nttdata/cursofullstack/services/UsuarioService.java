package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    public ResponseEntity<?> crearDesdeElService(UsuarioParaCrear dataEntrante);

    public ResponseEntity<?> consultarTodo();

    public ResponseEntity<?> consultarUno(Long id);

    public ResponseEntity<?> actualizar(Long idActualizar,UsuarioParaCrear data);

    public ResponseEntity<?> borrar(Long id);
}

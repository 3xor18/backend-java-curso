package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.AutorParaGuardar;
import com.nttdata.cursofullstack.dtos.CursoParaCrearDto;
import org.springframework.http.ResponseEntity;

public interface AutorService {

    public ResponseEntity<?> crear(AutorParaGuardar dto);

    public ResponseEntity<?> consultarTodos();

    public ResponseEntity<?> consultarPorId(Long id);

    public ResponseEntity<?> modificar(Long idAModificar,AutorParaGuardar data);

    public ResponseEntity<?> eliminar(Long idAEliminar);
}

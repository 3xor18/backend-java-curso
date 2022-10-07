package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.AutorCursoDto;
import com.nttdata.cursofullstack.dtos.CursoParaCrearDto;
import org.springframework.http.ResponseEntity;

public interface AutorCursoService {

    public ResponseEntity<?> crear(AutorCursoDto dto);

    public ResponseEntity<?> consultarTodos();

    public ResponseEntity<?> consultarPorId(Long id);

    public ResponseEntity<?> modificar(Long idAModificar, AutorCursoDto data);

    public ResponseEntity<?> eliminar(Long idAEliminar);
}

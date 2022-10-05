package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.CursoEditarPorNombre;
import com.nttdata.cursofullstack.dtos.CursoParaCrearDto;
import org.springframework.http.ResponseEntity;

public interface CursoService {

    public ResponseEntity<?> crear(CursoParaCrearDto dto);

    public ResponseEntity<?> consultarTodos();

    public ResponseEntity<?> consultarPorId(Long id);

    public ResponseEntity<?> modificar(Long idAModificar,CursoParaCrearDto data);

    public ResponseEntity<?> eliminar(Long idAEliminar);


    public ResponseEntity<?> modificarPorNombre(CursoEditarPorNombre dataEntrante);
}

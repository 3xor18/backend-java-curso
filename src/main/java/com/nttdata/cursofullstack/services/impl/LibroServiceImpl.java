package com.nttdata.cursofullstack.services.impl;

import com.nttdata.cursofullstack.entities.Libro;
import com.nttdata.cursofullstack.repositories.LibroRepository;
import com.nttdata.cursofullstack.services.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository repository;

    public LibroServiceImpl(LibroRepository repository) {
        this.repository = repository;
    }



    @Override
    public ResponseEntity<?> guardar() {
        //Crear una Nueva Instancia de Libro
        Libro entidad = new Libro();
        //Setear el nombre a "Nuevo Libro"
        entidad.setNombre("Nuevo Libro");
        //Guardar en BD y Leer lo Emitido por el Repository
        Libro guardado=repository.save(entidad);

        return ResponseEntity.status(HttpStatus.OK).body(guardado);
    }

}

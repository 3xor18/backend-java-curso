package com.nttdata.cursofullstack.services.impl;

import com.nttdata.cursofullstack.dtos.AutorParaGuardar;
import com.nttdata.cursofullstack.entities.Autor;
import com.nttdata.cursofullstack.entities.Curso;
import com.nttdata.cursofullstack.exceptions.personalizados.DataNoEncontrada;
import com.nttdata.cursofullstack.repositories.AutorRepository;
import com.nttdata.cursofullstack.services.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository repository;

    public AutorServiceImpl(AutorRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResponseEntity<?> crear(AutorParaGuardar dto) {
        try{
            //Crear la Entidad
            Autor autorNoGuardado=new Autor();
            //setear el Nombre desde el DTO
            autorNoGuardado.setNombre(dto.getNombre());
            //Gudardar en bd por el repository, Esto lo capturamos con una nueva instancia de la Entidad
            Autor AutorGuardado=repository.save(autorNoGuardado);
            //Retornamos algo
            return ResponseEntity.status(HttpStatus.OK).body(AutorGuardado);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> consultarTodos() {
        try{
            List<Autor> autores=repository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(autores);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> consultarPorId(Long id) {
        try{
            Autor autor=repository.findById(id)
                    .orElseThrow(()-> new DataNoEncontrada("No Encontre El Autor"));
            return ResponseEntity.status(HttpStatus.OK).body(autor);
        }
        catch (DataNoEncontrada e){
            return ResponseEntity.status(e.getResponseCode()).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> modificar(Long idAModificar, AutorParaGuardar data) {
        Autor autor=repository.findById(idAModificar).orElse(null);
        autor.setNombre(data.getNombre());
        Autor autorActualizado=repository.save(autor);
        return ResponseEntity.status(HttpStatus.OK).body(autorActualizado);
    }

    @Override
    public ResponseEntity<?> eliminar(Long idAEliminar) {
        try{
            //Buscar si el registro a eliminar Existe
            Autor enBd=repository.findById(idAEliminar)
                    .orElseThrow(()-> new DataNoEncontrada("No Encontre El Autor"));

            repository.deleteById(idAEliminar);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }
        catch (DataNoEncontrada e){
            return ResponseEntity.status(e.getResponseCode()).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

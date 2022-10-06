package com.nttdata.cursofullstack.services.impl;

import com.nttdata.cursofullstack.dtos.CursoEditarPorNombre;
import com.nttdata.cursofullstack.dtos.CursoParaCrearDto;
import com.nttdata.cursofullstack.entities.Curso;
import com.nttdata.cursofullstack.entities.Usuario;
import com.nttdata.cursofullstack.exceptions.personalizados.DataNoEncontrada;
import com.nttdata.cursofullstack.repositories.CursoRepository;
import com.nttdata.cursofullstack.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;

    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> crear(CursoParaCrearDto dto) {
        //Crear la entity y setear Valores de mi entity a guardar
        Curso noGuardado = new Curso();
        noGuardado.setNombre(dto.getNombreEntrante()+"-2022");
        noGuardado.setPremiun(dto.getPremiunEntrante());
        //Ocupar el repository y oupar el metodo save
        Curso guardado=repository.save(noGuardado);

        return ResponseEntity.status(HttpStatus.OK).body(guardado);
    }

    @Override
    public ResponseEntity<?> consultarTodos() {
        //Consultamos con el Repository a todos los registros
        List<Curso> cursosEnBd=repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cursosEnBd);
    }

    @Override
    public ResponseEntity<?> consultarPorId(Long id) {
        try{
            Curso cursoEnBD=repository.findById(id)
                    .orElseThrow(()-> new DataNoEncontrada("No Encontre El Curso"));
            return ResponseEntity.status(HttpStatus.OK).body(cursoEnBD);
        }
        catch (DataNoEncontrada e){
            return ResponseEntity.status(e.getResponseCode()).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> modificar(Long idAModificar, CursoParaCrearDto data) {
        Curso cursoEnBD=repository.findById(idAModificar).orElse(null);
        cursoEnBD.setNombre(data.getNombreEntrante());
        cursoEnBD.setPremiun(data.getPremiunEntrante());
        Curso cursoActualizado=repository.save(cursoEnBD);
        return ResponseEntity.status(HttpStatus.OK).body(cursoActualizado);
    }

    @Override
    public ResponseEntity<?> eliminar(Long idAEliminar) {
        repository.deleteById(idAEliminar);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

    @Override
    public ResponseEntity<?> modificarPorNombre(CursoEditarPorNombre dataEntrante) {
        //Buscar el curso a Buscar por el Nombre
        Curso enBd=repository.buscarPorNombre(dataEntrante.getNombreActual()).orElse(null);

        //Setearle a ese curso encontrado el nuevo Nombre
        enBd.setNombre(dataEntrante.getNuevoNombre());

        //ir a modificarlo en la BD (guardarlo)
        Curso editado= repository.save(enBd);

        //Retornar algo
        return ResponseEntity.status(HttpStatus.OK).body(editado);
    }
}

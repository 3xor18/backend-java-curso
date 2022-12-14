package com.nttdata.cursofullstack.services.impl;

import com.nttdata.cursofullstack.dtos.AutorCursoConsultaDto;
import com.nttdata.cursofullstack.dtos.AutorCursoDto;
import com.nttdata.cursofullstack.dtos.EstadoDto;
import com.nttdata.cursofullstack.entities.Autor;
import com.nttdata.cursofullstack.entities.AutorCurso;
import com.nttdata.cursofullstack.entities.Curso;
import com.nttdata.cursofullstack.exceptions.personalizados.DataNoEncontrada;
import com.nttdata.cursofullstack.repositories.AutorCursoRepository;
import com.nttdata.cursofullstack.repositories.AutorRepository;
import com.nttdata.cursofullstack.repositories.CursoRepository;
import com.nttdata.cursofullstack.services.AutorCursoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Log4j2
public class AutorCursoServiceImpl implements AutorCursoService {

    private final AutorCursoRepository autorCursorepository;

    private final AutorRepository autorRepository;

    private final CursoRepository cursoRepository;

    @Autowired
    private RestTemplate clientRest;

    public AutorCursoServiceImpl(AutorCursoRepository autorCursorepository, AutorRepository autorRepository, CursoRepository cursoRepository) {
        this.autorCursorepository = autorCursorepository;
        this.autorRepository = autorRepository;
        this.cursoRepository = cursoRepository;
    }


    @Override
    public ResponseEntity<?> crear(AutorCursoDto dto) {
        try{
            //Buscar Si EL Curso Existe
            Curso curso=cursoRepository.findById(dto.getIdCurso())
                    .orElseThrow(()-> new DataNoEncontrada("No Encontre El Curso"));

            //Buscar si el Autor Existe
            Autor autor=autorRepository.findById(dto.getIdAutor())
                    .orElseThrow(()-> new DataNoEncontrada("No Encontre El Autor"));

            //Crear la Entidad
            AutorCurso noGuardado=new AutorCurso();
            //setear el Nombre desde el DTO
            noGuardado.setAutor(autor);
            noGuardado.setCurso(curso);

            //Gudardar en bd por el repository, Esto lo capturamos con una nueva instancia de la Entidad
            AutorCurso guardado=autorCursorepository.save(noGuardado);
            //Retornamos algo
            return ResponseEntity.status(HttpStatus.OK).body(guardado);
        }
        catch (DataNoEncontrada e){
            return ResponseEntity.status(e.getResponseCode()).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> consultarTodos() {
        //Consultamos con el Repository a todos los registros
        List<AutorCurso> enBd=autorCursorepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(enBd);
    }

    @Override
    public ResponseEntity<?> consultarPorId(Long id) {
        try{
            AutorCurso enBd=autorCursorepository.findById(id)
                    .orElseThrow(()-> new DataNoEncontrada("No Encontre El Registro"));


            //Crear el nuevo Dto y setearle las variables
            AutorCursoConsultaDto dto = new AutorCursoConsultaDto();
            dto.setId(enBd.getId());
            dto.setAutor(enBd.getAutor());
            dto.setCurso(enBd.getCurso());

            //comunicarme con el micro service Estado y buscar el nombre y setearle el nombre
            ResponseEntity<EstadoDto> response = clientRest.exchange(
                    "http://localhost:8081/estado/"+enBd.getIdEstado(), HttpMethod.GET, null, EstadoDto.class
            );

            EstadoDto estadoDto = new EstadoDto();
            estadoDto.setId(enBd.getIdEstado());
            estadoDto.setNombre(response.getBody().getNombre());
            dto.setEstado(estadoDto);


            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }
        catch (DataNoEncontrada e){
            return ResponseEntity.status(e.getResponseCode()).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> modificar(Long idAModificar, AutorCursoDto data) {
        return null;
    }

    @Override
    public ResponseEntity<?> eliminar(Long idAEliminar) {
        autorCursorepository.deleteById(idAEliminar);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }
}

package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.AutorParaGuardar;
import com.nttdata.cursofullstack.dtos.CursoParaCrearDto;
import org.springframework.http.ResponseEntity;

public interface AutorService {

    /**
     * Esta funcion crea un nuevo autor en la bd, seteando el nombre que llega y el id es auto incremental
     * @param dto solo recibe el nombre del autor a guardar
     * @return retorna un Autor guardado en BD
     */
    public ResponseEntity<?> crear(AutorParaGuardar dto);

    /**
     * esta funcion Permite Buscar todos los Autores en la BD
      * @return Un listado de autores
     */
    public ResponseEntity<?> consultarTodos();

    /**
     * Esta funcion me permite consultar un Autor por su ID
     * @param id es un valor Intero y corresponde al ID en la tabla de Autores
     * @return Puede Retornar un Autor que haga match con el id solicitado o puede retornar un error que no se encuentra
     * el autor
     */
    public ResponseEntity<?> consultarPorId(Long id);

    public ResponseEntity<?> modificar(Long idAModificar,AutorParaGuardar data);

    public ResponseEntity<?> eliminar(Long idAEliminar);
}

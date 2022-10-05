package com.nttdata.cursofullstack.repositories;

import com.nttdata.cursofullstack.entities.Curso;
import com.nttdata.cursofullstack.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso,Long> {

    @Query("SELECT curso FROM Curso curso where curso.nombre=?1")
    Optional<Curso> buscarPorNombre(String nombre);
}

package com.nttdata.cursofullstack.repositories;

import com.nttdata.cursofullstack.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Integer> {
}

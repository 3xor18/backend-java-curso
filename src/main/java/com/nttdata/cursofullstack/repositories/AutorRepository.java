package com.nttdata.cursofullstack.repositories;

import com.nttdata.cursofullstack.entities.Autor;
import com.nttdata.cursofullstack.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}

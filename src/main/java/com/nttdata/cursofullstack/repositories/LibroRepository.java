package com.nttdata.cursofullstack.repositories;

import com.nttdata.cursofullstack.entities.Curso;
import com.nttdata.cursofullstack.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository  extends JpaRepository<Libro,Long> {
}

package com.nttdata.cursofullstack.repositories;

import com.nttdata.cursofullstack.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}

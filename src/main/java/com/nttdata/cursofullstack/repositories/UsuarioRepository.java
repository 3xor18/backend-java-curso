package com.nttdata.cursofullstack.repositories;

import com.nttdata.cursofullstack.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT x FROM Usuario x where x.nombre=?1")
    Optional<Usuario> buscarPorNombre(String nombre);
}

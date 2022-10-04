package com.nttdata.cursofullstack.services.impl;

import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import com.nttdata.cursofullstack.entities.Usuario;
import com.nttdata.cursofullstack.repositories.UsuarioRepository;
import com.nttdata.cursofullstack.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;


    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> crearDesdeElService(UsuarioParaCrear dataEntrante) {
        Usuario usuarioNoGuardado=new Usuario();
        usuarioNoGuardado.setNombre(dataEntrante.getNombre());
        usuarioNoGuardado.setClave(dataEntrante.getClave());
        Usuario usuarioCreado=repository.save(usuarioNoGuardado);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioCreado);
    }

    @Override
    public ResponseEntity<?> consultarTodo() {
        List<Usuario> usuarios= repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @Override
    public ResponseEntity<?> consultarUno(Long id) {
        Usuario usuarioEnBD=repository.findById(id).orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioEnBD);
    }

    @Override
    public ResponseEntity<?> actualizar(Long idActualizar, UsuarioParaCrear data) {
        Usuario usuarioEnBD=repository.findById(idActualizar).orElse(null);
        usuarioEnBD.setNombre(data.getNombre());
        usuarioEnBD.setClave(data.getClave());
        Usuario usuarioActualizado=repository.save(usuarioEnBD);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioActualizado);
    }

    @Override
    public ResponseEntity<?> borrar(Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }
}

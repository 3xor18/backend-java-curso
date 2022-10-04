package com.nttdata.cursofullstack.services.impl;

import com.nttdata.cursofullstack.dtos.UsuarioParaCrear;
import com.nttdata.cursofullstack.entities.Usuario;
import com.nttdata.cursofullstack.repositories.UsuarioRepository;
import com.nttdata.cursofullstack.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public ResponseEntity<?> buscarPorNombre(String nombre,String clave) {
        Usuario usuarioEnBD=repository.buscarPorNombre(nombre).orElse(null);
        boolean claveEnBDesIgualAClaveEntrante=usuarioEnBD.getClave().equals(clave);

        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("La clave OK",claveEnBDesIgualAClaveEntrante);
        respuesta.put("Nombre",nombre);
        respuesta.put("Clave en BD",usuarioEnBD.getClave());
        respuesta.put("Clave entrante",clave);

        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
}

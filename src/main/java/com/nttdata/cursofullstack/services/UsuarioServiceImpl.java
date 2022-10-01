package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.UsuarioParaGuardarDto;
import com.nttdata.cursofullstack.entities.Usuario;
import com.nttdata.cursofullstack.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> save(UsuarioParaGuardarDto dataEntrante) {
        Usuario dataNoGuardada=new Usuario();
        dataNoGuardada.setNombre(dataEntrante.getNombre());
        dataNoGuardada.setClave(dataEntrante.getClave());

        Usuario dataGuardada=repository.save(dataNoGuardada);
        return ResponseEntity.status(HttpStatus.OK).body(dataGuardada);
    }
}

package com.nttdata.cursofullstack.services;

import com.nttdata.cursofullstack.dtos.LibroParaGuardarDto;
import org.springframework.http.ResponseEntity;

public interface LibroService {

    public ResponseEntity<?> guardar(LibroParaGuardarDto dto);

}

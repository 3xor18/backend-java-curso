package com.nttdata.cursofullstack.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CursoEditarPorNombre {

    private String nombreActual;
    private String nuevoNombre;
}

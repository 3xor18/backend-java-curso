package com.nttdata.cursofullstack.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioParaGuardarDto {

    private String nombre;
    private String clave;
}

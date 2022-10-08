package com.nttdata.cursofullstack.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nttdata.cursofullstack.entities.Autor;
import com.nttdata.cursofullstack.entities.Curso;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorCursoConsultaDto {

    private Long id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Autor autor;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Curso curso;
    private EstadoDto estado;
}

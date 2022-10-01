package com.nttdata.cursofullstack.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Mapear o decirle al Springboot que esto sera una tabla en la BD
@Entity
//Para darle el nombre que tendra en nuestra BD
@Table(name = "usuarios")
//Para tener Gettes y Setters
@Data
//Para tener constructores Sin Parametros
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String clave;
    private Boolean isOk;
}

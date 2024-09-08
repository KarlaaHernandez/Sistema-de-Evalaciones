package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumnos")
public class Alumno {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    public  String nombre;
    private String codigo;
    private String carrera;
    private  String grupo;
}

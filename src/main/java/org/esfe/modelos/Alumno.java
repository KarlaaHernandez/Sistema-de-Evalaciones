package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "alumno")
    private List<Evaluacion> evaluaciones;

    @OneToMany(mappedBy = "alumno")
    private List<EvaluacionDocente> evaluaciondocente;
}

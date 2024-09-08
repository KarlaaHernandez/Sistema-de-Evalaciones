package org.esfe.dtos.alumno;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AlumnoGuardar implements Serializable {
    private String nombre;
    private String codigo;
    private String carrera;
    private String grupo;
}

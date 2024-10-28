package org.esfe.dtos.alumno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlumnoGuardar implements Serializable {
    private String nombre;
    private String codigo;
    private String carrera;
    private String grupo;
}

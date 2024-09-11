package org.esfe.dtos.servicio;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.alumno.AlumnoSalida;

import java.io.Serializable;

@Getter
@Setter
public class ServicioSalida implements Serializable {
    private String nombre;
}

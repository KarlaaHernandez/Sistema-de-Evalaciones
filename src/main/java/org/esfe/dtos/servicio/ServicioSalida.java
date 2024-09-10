package org.esfe.dtos.servicio;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.alumno.AlumnoSalida;

import java.io.Serializable;

@Getter
@Setter
public class ServicioSalida implements Serializable {
    private String biblioteca;
    private String cafeteria;
    private String registroAcademico;
    private String atencionAlCliente;
    private AlumnoSalida alumno;
}

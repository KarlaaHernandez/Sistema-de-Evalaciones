package org.esfe.dtos.docente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DocenteGuardar implements Serializable {
    private String nombre;
    private int telefono;
    private String especialidad;
    private String email;
    private String grupo;
}

package org.esfe.dtos.docente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocenteGuardar implements Serializable {
    private String nombre;
    private int telefono;
    private String especialidad;
    private String email;
    private String grupo;
}

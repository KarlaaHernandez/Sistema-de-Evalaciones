package org.esfe.dtos.criterioDocente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class CriterioDocenteGuardar implements Serializable {

    private String nombre;
    private Integer DocenteId;
}

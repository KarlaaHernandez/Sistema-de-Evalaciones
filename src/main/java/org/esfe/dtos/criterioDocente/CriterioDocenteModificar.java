package org.esfe.dtos.criterioDocente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class CriterioDocenteModificar implements Serializable {
    private Integer id;
    private String nombre;
    private Integer DocenteId;
}

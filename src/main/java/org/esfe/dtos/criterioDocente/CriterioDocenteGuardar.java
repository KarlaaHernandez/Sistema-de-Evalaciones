package org.esfe.dtos.criterioDocente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriterioDocenteGuardar implements Serializable {

    private String nombre;
    private Integer DocenteId;
}

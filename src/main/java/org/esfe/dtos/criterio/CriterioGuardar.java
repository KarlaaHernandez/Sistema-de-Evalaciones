package org.esfe.dtos.criterio;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class CriterioGuardar implements Serializable {
    private String nombre;
    private Integer ServicioId;
}

package org.esfe.dtos.criterio;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class CriterioModificar implements Serializable {
    private Integer id;
    private String nombre;
    private Integer ServiceId;
}
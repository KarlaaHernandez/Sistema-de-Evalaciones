package org.esfe.dtos.criterio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CriterioModificar implements Serializable {
    private Integer id;
    private String nombre;
    private Integer ServicioId;
}

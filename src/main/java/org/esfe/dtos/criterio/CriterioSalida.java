package org.esfe.dtos.criterio;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.servicio.ServicioSalida;

import java.io.Serializable;

@Getter
@Setter
public class CriterioSalida implements Serializable {
    private Integer id;
    private String nombre;
    private ServicioSalida servicio;
}

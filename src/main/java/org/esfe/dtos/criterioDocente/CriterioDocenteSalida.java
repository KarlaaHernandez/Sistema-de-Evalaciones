package org.esfe.dtos.criterioDocente;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.servicio.ServicioSalida;

import java.io.Serializable;
@Getter
@Setter
public class CriterioDocenteSalida implements Serializable {

    private Integer id;
    private String nombre;
    private ServicioSalida docente;
}

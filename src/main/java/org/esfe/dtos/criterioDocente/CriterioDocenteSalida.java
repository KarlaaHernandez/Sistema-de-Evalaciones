package org.esfe.dtos.criterioDocente;

import org.esfe.dtos.servicio.ServicioSalida;

import java.io.Serializable;

public class CriterioDocenteSalida implements Serializable {

    private Integer id;
    private String nombre;
    private ServicioSalida docente;
}

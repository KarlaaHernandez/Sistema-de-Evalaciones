package org.esfe.dtos.servicio;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ServicioModificar implements Serializable {
    private Integer id;
    private String nombre;
}

package org.esfe.dtos.detalle;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DetalleModificar implements Serializable {

    private Integer id;
    private Integer evaluacionId;
    private Integer criterioId;
}

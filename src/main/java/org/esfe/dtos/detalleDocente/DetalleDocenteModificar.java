package org.esfe.dtos.detalleDocente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DetalleDocenteModificar implements Serializable {
    private Integer id;
    private Integer evaluacionDocente_Id;
    private Integer criterioDocenteId;
}

package org.esfe.dtos.detalle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleModificar implements Serializable {

    private Integer id;
    private Integer evaluacion_Id;
    private Integer criterioId;
}

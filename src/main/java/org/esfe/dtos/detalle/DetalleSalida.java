package org.esfe.dtos.detalle;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.criterio.CriterioSalida;
import org.esfe.dtos.evalucion.EvaluacionSalida;

import java.io.Serializable;

@Getter
@Setter
public class DetalleSalida implements Serializable {

    private Integer id;
    private EvaluacionSalida evaluacion;
    private CriterioSalida criterio;
}

package org.esfe.dtos.detalleDocente;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.criterioDocente.CriterioDocenteSalida;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteSalida;

import java.io.Serializable;
@Getter
@Setter

public class DetalleDocenteSalida implements Serializable {

    private Integer id;
    private EvaluacionDocenteSalida evaluacionDocente;
    private CriterioDocenteSalida criterioDocente;
}

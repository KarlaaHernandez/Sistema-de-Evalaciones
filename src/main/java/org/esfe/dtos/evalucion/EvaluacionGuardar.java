package org.esfe.dtos.evalucion;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class EvaluacionGuardar implements Serializable {

    private int anio;
    private  int ciclo;
    private LocalDate fecha;
    private Integer alumnoId;

}

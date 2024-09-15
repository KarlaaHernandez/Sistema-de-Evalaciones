package org.esfe.dtos.evalucion;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class EvaluacionGuardar implements Serializable {
    private Integer id;
    private int anio;
    private LocalDate fecha;
    private Integer alumnoId;
    private Integer servicioId;
    private Set<Integer> criteriosId;
}

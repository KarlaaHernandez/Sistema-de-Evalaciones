package org.esfe.dtos.evaluaciondocente;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class EvaluacionDocenteGuardar {
    private int anio;
    private  int ciclo;
    private LocalDate fecha;
    private Integer alumno_Id;
    private  Integer docenteId;
}

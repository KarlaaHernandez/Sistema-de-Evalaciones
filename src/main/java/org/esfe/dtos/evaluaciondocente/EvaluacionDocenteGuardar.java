package org.esfe.dtos.evaluaciondocente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EvaluacionDocenteGuardar {
    private int anio;
    private  int ciclo;
    private LocalDate fecha;
    private Integer alumno_Id;
    private  Integer docenteId;
}

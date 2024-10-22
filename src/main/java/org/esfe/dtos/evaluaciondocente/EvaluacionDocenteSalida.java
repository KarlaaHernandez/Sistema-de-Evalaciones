package org.esfe.dtos.evaluaciondocente;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.alumno.AlumnoSalida;
import org.esfe.dtos.docente.DocenteSalida;

import java.time.LocalDate;
@Getter
@Setter
public class EvaluacionDocenteSalida {
    private Integer id;
    private int anio;
    private  int ciclo;
    private LocalDate fecha;
    private AlumnoSalida alumno;
    private DocenteSalida docente;
}

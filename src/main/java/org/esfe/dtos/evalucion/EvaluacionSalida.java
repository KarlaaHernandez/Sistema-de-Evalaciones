package org.esfe.dtos.evalucion;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.alumno.AlumnoSalida;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class EvaluacionSalida implements Serializable {
    private Integer id;
    private int anio;
    private  int ciclo;
    private LocalDate fecha;
    private AlumnoSalida alumno;

}

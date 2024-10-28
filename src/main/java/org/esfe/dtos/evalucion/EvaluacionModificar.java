package org.esfe.dtos.evalucion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvaluacionModificar implements Serializable {
    private Integer id;
    private int anio;
    private  int ciclo;
    private LocalDate fecha;
    private Integer alumnoId;

}

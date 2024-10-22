package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "evaluacionesdocentes")
public class EvaluacionDocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int anio;

    private int ciclo;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

//    @OneToMany(mappedBy = "evaluaciondocente")
//    List<DetalleDocente> detalles;
}

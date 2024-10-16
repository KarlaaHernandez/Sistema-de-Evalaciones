package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "evaluaciones")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int anio;

    private int ciclo;

    private LocalDate fecha;



    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @OneToMany(mappedBy = "evaluacion")
    List<Detalle> detalle;


}

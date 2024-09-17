package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "evaluaciones")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int anio;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @ManyToMany
    @JoinTable(
            name = "encuesta_criterio",
            joinColumns = @JoinColumn(name = "encuesta_id"),
            inverseJoinColumns = @JoinColumn(name = "criterio_id")
    )
    private List<Criterio> criterios;





}

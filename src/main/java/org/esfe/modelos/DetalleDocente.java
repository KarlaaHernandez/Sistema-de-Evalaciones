package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "detallesDocente")
public class DetalleDocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="evaluacionDocente_id")
    private EvaluacionDocente evaluacionDocente;


    @ManyToOne
    @JoinColumn(name = "criterioDocente_id")
    private CriterioDocente criterioDocente;
}

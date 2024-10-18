package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "detalles")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="evaluacion_id")
    private Evaluacion evaluacion;


    @ManyToOne
    @JoinColumn(name = "criterio_id")
    private Criterio criterio;
}

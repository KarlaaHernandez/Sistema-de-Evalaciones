package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalles")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="evaluaciones_id")
    private Evaluacion evaluacion;


    @OneToOne
    @JoinColumn(name = "criterio_id")
    private Criterio criterio;
}

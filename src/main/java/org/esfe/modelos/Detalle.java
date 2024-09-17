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

    @ManyToMany
    @JoinColumn(name ="evaluaciones_id")
    private Evaluacion evaluacion;

    @OneToMany(mappedBy = "detalle")
    private Criterio criterio;
}

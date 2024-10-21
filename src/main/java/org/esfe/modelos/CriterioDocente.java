package org.esfe.modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

@Table(name = "criteriosDocente")
public class CriterioDocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

//    @OneToMany(mappedBy = "criterioDocente")
//    private List<Detalle> detalles;

}

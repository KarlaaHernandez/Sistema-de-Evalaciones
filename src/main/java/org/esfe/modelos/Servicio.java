package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;


    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @OneToMany(mappedBy = "servicio")
    private List<Criterio> criterios;
}

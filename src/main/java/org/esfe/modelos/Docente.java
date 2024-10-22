package org.esfe.modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nombre;
    private int telefono;
    private String especialidad;
    private String email;
    private String grupo;
    @OneToMany(mappedBy = "docente")
    private List<EvaluacionDocente> evaluaciondocente;

}

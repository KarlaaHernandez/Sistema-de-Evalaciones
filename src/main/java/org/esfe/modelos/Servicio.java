package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String biblioteca;
    private String  cafeteria;
    private String registroAcademico;
    private  String atencionAlCliente;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;


    public void setId(Object o) {
    }
}

package org.esfe.seguridad.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioRegistrar {
    private String nombre;
    private String apellido;
    private String correo;
    private String carrera;
    private String grupo;
    private String login;
    private String clave;
    private Integer rolId;
}
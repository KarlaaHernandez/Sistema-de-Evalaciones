package org.esfe.servicios.interfaces;

import org.esfe.dtos.servicio.ServicioGuardar;
import org.esfe.dtos.servicio.ServicioModificar;
import org.esfe.dtos.servicio.ServicioSalida;
import org.esfe.modelos.Servicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServicioService {
    List<ServicioSalida> obtenerTodos();



    Page<ServicioSalida> obtenerTodosPaginados(Pageable pageable);

    ServicioSalida obtenerPorId(Integer id);

    ServicioSalida crear(ServicioGuardar servicioGuardar);

    ServicioSalida editar(ServicioModificar servicioModificar);

    void eliminarPorId(Integer id);
}

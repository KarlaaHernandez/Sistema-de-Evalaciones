package org.esfe.servicios.interfaces;

import org.esfe.dtos.alumno.AlumnoGuardar;
import org.esfe.dtos.alumno.AlumnoModificar;
import org.esfe.dtos.alumno.AlumnoSalida;
import org.esfe.dtos.detalle.DetalleGuardar;
import org.esfe.dtos.detalle.DetalleModificar;
import org.esfe.dtos.detalle.DetalleSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDetalleService {
    List<DetalleSalida> obtenerTodos();

    Page<DetalleSalida> obtenerTodosPaginados(Pageable pageable);

    DetalleSalida obtenerPorId(Integer id);

    DetalleSalida crear(DetalleGuardar detalleGuardar);

    DetalleSalida editar(DetalleModificar detalleModificar);

    void eliminarPorId(Integer id);
}

package org.esfe.servicios.interfaces;


import org.esfe.dtos.detalleDocente.DetalleDocenteGuardar;
import org.esfe.dtos.detalleDocente.DetalleDocenteModificar;
import org.esfe.dtos.detalleDocente.DetalleDocenteSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDetalleDocenteService {
    List<DetalleDocenteSalida> obtenerTodos();

    Page<DetalleDocenteSalida> obtenerTodosPaginados(Pageable pageable);

    DetalleDocenteSalida obtenerPorId(Integer id);

    DetalleDocenteSalida crear(DetalleDocenteGuardar detalleDocenteGuardar);

    DetalleDocenteSalida editar(DetalleDocenteModificar detalleDocenteModificar);

    void eliminarPorId(Integer id);
}

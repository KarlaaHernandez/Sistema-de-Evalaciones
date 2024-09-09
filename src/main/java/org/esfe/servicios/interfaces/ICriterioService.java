package org.esfe.servicios.interfaces;


import org.esfe.dtos.criterio.CriterioGuardar;
import org.esfe.dtos.criterio.CriterioModificar;
import org.esfe.dtos.criterio.CriterioSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICriterioService {
    List<CriterioSalida> obtenerTodos();

    Page<CriterioSalida> obtenerTodosPaginados(Pageable pageable);

    CriterioSalida obtenerPorId(Integer id);

    CriterioSalida crear(CriterioGuardar alumnoGuardar);

    CriterioSalida editar(CriterioModificar alumnoModificar);

    void eliminarPorId(Integer id);
}

package org.esfe.servicios.interfaces;

import org.esfe.dtos.criterioDocente.CriterioDocenteGuardar;
import org.esfe.dtos.criterioDocente.CriterioDocenteModificar;
import org.esfe.dtos.criterioDocente.CriterioDocenteSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICriterioDocenteService {
    List<CriterioDocenteSalida> obtenerTodos();

    Page<CriterioDocenteSalida> obtenerTodosPaginados(Pageable pageable);

    CriterioDocenteSalida obtenerPorId(Integer id);

    CriterioDocenteSalida crear(CriterioDocenteGuardar docenteGuardar);

    CriterioDocenteSalida editar(CriterioDocenteModificar docenteModificar);

    void eliminarPorId(Integer id);
}

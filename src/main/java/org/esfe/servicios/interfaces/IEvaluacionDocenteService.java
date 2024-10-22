package org.esfe.servicios.interfaces;

import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteGuardar;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteModificar;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteSalida;
import org.esfe.dtos.evalucion.EvaluacionGuardar;
import org.esfe.dtos.evalucion.EvaluacionModificar;
import org.esfe.dtos.evalucion.EvaluacionSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEvaluacionDocenteService {
    List<EvaluacionDocenteSalida> obtenerTodos();

    Page<EvaluacionDocenteSalida> obtenerTodosPaginados(Pageable pageable);

    EvaluacionDocenteSalida obtenerPorId(Integer id);

    EvaluacionDocenteSalida crear(EvaluacionDocenteGuardar evaluaciondocenteGuardar);

    EvaluacionDocenteSalida editar(EvaluacionDocenteModificar evaluaciondocenteModificar);

    void eliminarPorId(Integer id);
}

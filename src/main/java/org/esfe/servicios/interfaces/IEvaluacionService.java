package org.esfe.servicios.interfaces;

import org.esfe.dtos.evalucion.EvaluacionGuardar;
import org.esfe.dtos.evalucion.EvaluacionModificar;
import org.esfe.dtos.evalucion.EvaluacionSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEvaluacionService {

    List<EvaluacionSalida> obtenerTodos();

    Page<EvaluacionSalida> obtenerTodosPaginados(Pageable pageable);

    EvaluacionSalida obtenerPorId(Integer id);

    EvaluacionSalida crear(EvaluacionGuardar evaluacionGuardar);

    EvaluacionSalida editar(EvaluacionModificar evaluacionModificar);

    void eliminarPorId(Integer id);
}

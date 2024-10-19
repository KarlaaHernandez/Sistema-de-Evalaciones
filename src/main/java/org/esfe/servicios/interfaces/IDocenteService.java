package org.esfe.servicios.interfaces;


import org.esfe.dtos.docente.DocenteGuardar;
import org.esfe.dtos.docente.DocenteModificar;
import org.esfe.dtos.docente.DocenteSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDocenteService {
    List<DocenteSalida> obtenerTodos();

    Page<DocenteSalida> obtenerTodosPaginados(Pageable pageable);

    DocenteSalida obtenerPorId(Integer id);

    DocenteSalida crear(DocenteGuardar alumnoGuardar);

    DocenteSalida editar(DocenteModificar alumnoModificar);

    void eliminarPorId(Integer id);
}

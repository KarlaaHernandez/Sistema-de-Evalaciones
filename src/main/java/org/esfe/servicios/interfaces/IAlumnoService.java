package org.esfe.servicios.interfaces;

import org.esfe.dtos.alumno.AlumnoGuardar;
import org.esfe.dtos.alumno.AlumnoModificar;
import org.esfe.dtos.alumno.AlumnoSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAlumnoService {
    List<AlumnoSalida> obtenerTodos();

    Page<AlumnoSalida> obtenerTodosPaginados(Pageable pageable);

    AlumnoSalida obtenerPorId(Integer id);

    AlumnoSalida crear(AlumnoGuardar alumnoGuardar);

    AlumnoSalida editar(AlumnoModificar alumnoModificar);

    void eliminarPorId(Integer id);
}

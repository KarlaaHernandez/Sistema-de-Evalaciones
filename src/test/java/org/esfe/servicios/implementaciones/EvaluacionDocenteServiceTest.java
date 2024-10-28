package org.esfe.servicios.implementaciones;

import org.esfe.dtos.criterioDocente.CriterioDocenteGuardar;
import org.esfe.dtos.criterioDocente.CriterioDocenteModificar;
import org.esfe.dtos.criterioDocente.CriterioDocenteSalida;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteGuardar;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteModificar;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteSalida;
import org.esfe.servicios.interfaces.ICriterioDocenteService;
import org.esfe.servicios.interfaces.IEvaluacionDocenteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest


class EvaluacionDocenteServiceTest {
    @Autowired
    private IEvaluacionDocenteService evaluacionDocenteService;


    @Test
    void crear() {

        EvaluacionDocenteSalida salida = evaluacionDocenteService.crear(new EvaluacionDocenteGuardar(2024, 4, LocalDate.of(2024,10,28), 2,3));
        assertNotEquals(null, salida);
    }

    @Test
    void obtenerTodos() {
        int actual = evaluacionDocenteService.obtenerTodos().size();
        assertNotEquals(0, actual);
    }

    @Test
    void obtenerTodosPaginados() {
        int actual = evaluacionDocenteService.obtenerTodosPaginados(PageRequest.of(0, 10)).getSize();
        assertNotEquals(0, actual);
    }

    @Test
    void obtenerPorId() {
        EvaluacionDocenteSalida salida = evaluacionDocenteService.obtenerPorId(1);
        assertNotEquals(null, salida);
    }



    @Test
    void editar() {
        EvaluacionDocenteSalida salida = evaluacionDocenteService.editar(new EvaluacionDocenteModificar(1,2024, 4, LocalDate.of(2024,10,28), 2,3));
        assertNotEquals(null, salida);
    }

    @Test
    void eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                evaluacionDocenteService.eliminarPorId(3);
            }
        });
    }
}
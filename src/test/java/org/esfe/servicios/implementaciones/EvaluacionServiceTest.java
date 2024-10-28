package org.esfe.servicios.implementaciones;

import org.esfe.dtos.criterio.CriterioGuardar;
import org.esfe.dtos.criterio.CriterioModificar;
import org.esfe.dtos.criterio.CriterioSalida;
import org.esfe.dtos.evalucion.EvaluacionGuardar;
import org.esfe.dtos.evalucion.EvaluacionModificar;
import org.esfe.dtos.evalucion.EvaluacionSalida;
import org.esfe.servicios.interfaces.ICriterioService;
import org.esfe.servicios.interfaces.IEvaluacionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EvaluacionServiceTest {

    @Autowired
    private IEvaluacionService evaluacionService;

    @Test
    void crear() {
        EvaluacionSalida salida = evaluacionService.crear(new EvaluacionGuardar(2, 2, LocalDate.of(2024, 10,23), 2));
        assertNotEquals(null, salida);

    }


    @Test
    void obtenerTodos() {
        int actual = evaluacionService.obtenerTodos().size();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerTodosPaginados() {
        int actual = evaluacionService.obtenerTodosPaginados(PageRequest.of(0, 10)).getSize();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerPorId() {
        EvaluacionSalida salida = evaluacionService.obtenerPorId(1);
        assertNotEquals(null, salida);

    }


    @Test
    void editar() {
        EvaluacionSalida salida = evaluacionService.editar(new EvaluacionModificar(2,2, 2, LocalDate.of(2024, 10,23), 2));
        assertNotEquals(null, salida);

    }

    @Test
    void eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                evaluacionService.eliminarPorId(3);
            }
        });
    }
}
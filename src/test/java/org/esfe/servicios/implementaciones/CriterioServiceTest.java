package org.esfe.servicios.implementaciones;

import org.esfe.dtos.criterio.CriterioGuardar;
import org.esfe.dtos.criterio.CriterioModificar;
import org.esfe.dtos.criterio.CriterioSalida;
import org.esfe.servicios.interfaces.ICriterioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CriterioServiceTest {

    @Autowired
    private ICriterioService criterioService;

    @Test
    void crear() {
        CriterioSalida salida = criterioService.crear(new CriterioGuardar("Empatia", 1));
        assertNotEquals(null, salida);
    }

    @Test
    void obtenerTodos() {
        int actual = criterioService.obtenerTodos().size();
                assertNotEquals(0, actual);
    }

    @Test
    void obtenerTodosPaginados() {
        int actual = criterioService.obtenerTodosPaginados(PageRequest.of(0, 10)).getSize();
        assertNotEquals(0, actual);
    }

    @Test
    void obtenerPorId() {
        CriterioSalida salida = criterioService.obtenerPorId(1);
        assertNotEquals(null, salida);
    }



    @Test
    void editar() {
        CriterioSalida salida = criterioService.editar(new CriterioModificar(1, "criterio modificado", 2));
        assertNotEquals(null, salida);
    }

    @Test
    void eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                criterioService.eliminarPorId(6);
            }
        });


    }
}
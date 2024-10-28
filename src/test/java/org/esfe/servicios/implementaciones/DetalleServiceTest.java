package org.esfe.servicios.implementaciones;

import org.esfe.dtos.criterio.CriterioGuardar;
import org.esfe.dtos.criterio.CriterioModificar;
import org.esfe.dtos.criterio.CriterioSalida;
import org.esfe.dtos.detalle.DetalleGuardar;
import org.esfe.dtos.detalle.DetalleModificar;
import org.esfe.dtos.detalle.DetalleSalida;
import org.esfe.servicios.interfaces.ICriterioService;
import org.esfe.servicios.interfaces.IDetalleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DetalleServiceTest {

    @Autowired
    private IDetalleService detalleService;

    @Test
    void crear() {
        DetalleSalida salida = detalleService.crear(new DetalleGuardar(6,1,1));
        assertNotEquals(null, salida);

    }


    @Test
    void obtenerTodos() {
        int actual = detalleService.obtenerTodos().size();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerTodosPaginados() {
        int actual = detalleService.obtenerTodosPaginados(PageRequest.of(0, 10)).getSize();
        assertNotEquals(0, actual);
    }

    @Test
    void obtenerPorId() {
        DetalleSalida salida = detalleService.obtenerPorId(1);
        assertNotEquals(null, salida);

    }


    @Test
    void editar() {

            DetalleSalida salida = detalleService.editar(new DetalleModificar(6, 1, 1));
            assertNotEquals(null, salida);

        }

    @Test
    void eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                detalleService.eliminarPorId(5);
            }
        });
    }
}
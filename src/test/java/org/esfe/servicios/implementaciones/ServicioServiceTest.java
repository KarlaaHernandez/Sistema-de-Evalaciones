package org.esfe.servicios.implementaciones;

import org.esfe.dtos.alumno.AlumnoGuardar;
import org.esfe.dtos.alumno.AlumnoModificar;
import org.esfe.dtos.alumno.AlumnoSalida;
import org.esfe.dtos.servicio.ServicioGuardar;
import org.esfe.dtos.servicio.ServicioModificar;
import org.esfe.dtos.servicio.ServicioSalida;
import org.esfe.servicios.interfaces.IServicioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServicioServiceTest {

    @Autowired
    private IServicioService servicioService;

    @Test
    void crear() {
        ServicioSalida salida = servicioService.crear(new ServicioGuardar("Registro Academico"));
        assertNotEquals(null, salida);

    }

    @Test
    void obtenerTodos() {
        int actual = servicioService.obtenerTodos().size();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerTodosPaginados() {
        int actual = servicioService.obtenerTodosPaginados(PageRequest.of(0, 10)).getSize();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerPorId() {
        ServicioSalida salida = servicioService.obtenerPorId(2);
        assertNotEquals(null, salida);


    }


    @Test
    void editar() {
        ServicioSalida salida = servicioService.editar(new ServicioModificar(1,"servicio Modificado")
        );
        assertNotEquals(null, salida);

    }

    @Test
    void eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                servicioService.eliminarPorId(1);
            }
        });
    }
}